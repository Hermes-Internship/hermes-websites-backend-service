package ro.societateahermes.backendservice.controller;


import ro.societateahermes.backendservice.entities.DTO.CDMemberDTO;

import java.util.List;

public interface CDMemberControllerInterface {
    void saveCDMember(CDMemberDTO member);

    void deleteCDMember(Long CDMemberID);

    void updateCDMember(Long CDMemberID, CDMemberDTO cdMemberDTO);

    List<CDMemberDTO> getAllCDMembers();
}
