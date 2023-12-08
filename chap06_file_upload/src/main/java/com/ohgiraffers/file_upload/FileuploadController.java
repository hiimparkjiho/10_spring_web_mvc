package com.ohgiraffers.file_upload;

import jakarta.annotation.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class FileuploadController {
    
    @Resource
    private ResourceLoader resourceLoader;

    @RequestMapping(value = {"/", "main"})
    public String index(){
        return "main";
    }

    @PostMapping("single_file")
    public String singleFileupload(@RequestParam MultipartFile singleFile, String singleFileDescription, Model model) throws IOException {
        System.out.println("single file: " + singleFile);
        System.out.println("원본 파일 이름: " + singleFile.getOriginalFilename());
        System.out.println("input name: " + singleFile.getName());
        //System.out.println("원본 파일 객체: " + singleFile.getBytes());   // 컴퓨터에서 인식하고 있는 데이터
        System.out.println("원본 파일 사이즈: " + singleFile.getSize());   //

        // 파일을 저장할 경로 설정
//        String root = "c:/upload_files";    // ftp서버나 node.js서버 등에서 관리하기도 한다
//        String filePath = root + "/single";
        // 원래는 service에서 함
        String filePath = resourceLoader.getResource("classpath:static/img/").getFile().getAbsolutePath();

        File dir = new File(filePath);
        System.out.println(dir.getAbsolutePath());
        /*
        * 보관할 때 확장자를 떼어놓고 보관하다가 꺼낼 때 이미지에.확장자를 붙여서 사용자에게 전송하는 방법도 있다.
        * */

        if(!dir.exists()){  // 경로가 없으면 만들어준다
            dir.mkdirs();
        }

        String originFileName = singleFile.getOriginalFilename();   // 파일의 원본 이름
        String ext = originFileName.substring(originFileName.lastIndexOf(".")); // 파일의 확장자(이미지가 아닌 파일을 업로드할 때 반환해주기 위해)
        String savedName = UUID.randomUUID().toString().replace("-", "") + ext; // 랜덤된 값을 중복되지 않게 랜덤으로 구현

        try{
            System.out.println("filePath ============================= " + filePath);
            singleFile.transferTo(new File(filePath + "/" + savedName));
            model.addAttribute("message", "파일 업로드 성공");
            model.addAttribute("img", "static/img/" + savedName);// db에 저장하면 끝
        }catch(IOException e){
            e.printStackTrace();
            model.addAttribute("message", "파일 업로드 실패");
        }

        System.out.println("singleFileDescription: " + singleFileDescription);

        return "result";
    }

    @PostMapping("multi-file")
    public String multiFileUpload(@RequestParam List<MultipartFile> multipartFiles,
                                  String multiFileDescription, Model model){
        System.out.println("multiFiles: " + multipartFiles);
        System.out.println("multifileDescription: " + multiFileDescription);

        String root = "c:/upload-files";
        String filePath = root + "/multi";

        File dir = new File(filePath);
        if(!dir.exists()){
            // dir.mkdir // 상위 폴더가 존재하는 경우
            dir.mkdirs();   // 폴더를 다수 만들 경우 dirs를 사용
        }

        List<FileDTO> files = new ArrayList<>();

        try {
            for (MultipartFile file: multipartFiles) {
                String originFileName = file.getOriginalFilename();
                String ext = originFileName.substring(originFileName.lastIndexOf(".")); // 확장자
                String savedName = UUID.randomUUID().toString().replace("-", "") + ext; //
                files.add(new FileDTO(originFileName, savedName, filePath, multiFileDescription));
                file.transferTo(new File(filePath, "/" + savedName));
                }
            model.addAttribute("message", "다중 파일 업로드 성공");
        } catch (IOException e){
            e.printStackTrace();

            for (FileDTO file: files){
                new File(filePath, "/" + file.getSavedName()).delete();
            }
            model.addAttribute("message", "다중 파일 업로드 실패");
        }
        return "result";
    }

}
