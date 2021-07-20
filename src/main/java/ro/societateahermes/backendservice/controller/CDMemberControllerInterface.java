package ro.societateahermes.backendservice.controller;


import ro.societateahermes.backendservice.entities.dto.CDMemberDTO;

import java.util.List;

public interface CDMemberControllerInterface {
    void saveCDMember(CDMemberDTO member);

    void deleteCDMember(Long CDMemberID);

    void updateCDMember(CDMemberDTO cdMemberDTO);

    List<CDMemberDTO> getAllCDMembers();
}
