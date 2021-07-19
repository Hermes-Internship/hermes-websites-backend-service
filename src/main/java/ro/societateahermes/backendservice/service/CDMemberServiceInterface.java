package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.entities.CDMember;

import java.util.List;

public interface CDMemberServiceInterface {
    void save(CDMember CDMember);

    void delete(Long CDMemberID);

    void update(Long CDMemberID, CDMember cdMember);

    List<CDMember> getAllCDMembers();
}
