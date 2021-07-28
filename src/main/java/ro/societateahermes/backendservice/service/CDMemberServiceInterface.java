package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.entities.cdMember.CDMember;
import ro.societateahermes.backendservice.entities.dto.CDMemberDTO;

import java.util.List;

public interface CDMemberServiceInterface {
    void save(CDMember CDMember);

    void delete(Long CDMemberID);

    void update(CDMember cdMember);

    List<CDMember> getAllCDMembers();

    boolean isValidCdMember(CDMemberDTO cdMemberDTO);
}
