package ro.societateahermes.backendservice.controller;


import ro.societateahermes.backendservice.entities.CDMember;
import ro.societateahermes.backendservice.entities.DTO.CDMemberDTO;

import java.util.List;

public interface CDMemberControllerInterface {
    CDMember saveCDMember(CDMember member);

    void deleteCDMember(Long CDMemberID);

    CDMember updateCDMember(Long CDMemberID, CDMemberDTO cdMemberDTO);

    List<CDMember> getAllCDMembers();
}
