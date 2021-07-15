package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.entities.CDMember;
import ro.societateahermes.backendservice.entities.DTO.CDMemberDTO;

import java.util.List;

public interface CDMemberServiceInterface {
    void save(CDMember CDMember);

    void delete(Long CDMemberID);

    void update(Long CDMemberID, CDMemberDTO cdMemberDTO);

    List<CDMember> getAllCDMembers();
}
