package ro.societateahermes.backendservice.controller;

import org.springframework.web.multipart.MultipartFile;
import ro.societateahermes.backendservice.entities.CDMember;
import ro.societateahermes.backendservice.entities.DTO.CDMemberDTO;

import java.util.List;

public interface CDMemberControllerInterface {
    void saveCDMember(CDMember member);

    void deleteCDMember(Long CDMemberID);

    void updateCDMember(Long CDMemberID, CDMemberDTO cdMemberDTO);

    List<CDMember> getAllCDMembers();
}
