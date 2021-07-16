package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.entities.CDMember;
import ro.societateahermes.backendservice.entities.DTO.CDMemberDTO;

import java.util.List;

public interface CDMemberServiceInterface {
    CDMember save(CDMember CDMember);

    void delete(Long CDMemberID);

    CDMember update(Long CDMemberID, CDMemberDTO cdMemberDTO);

    List<CDMember> getAllCDMembers();
}
