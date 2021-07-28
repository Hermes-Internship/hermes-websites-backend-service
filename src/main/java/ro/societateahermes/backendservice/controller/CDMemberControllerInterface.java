package ro.societateahermes.backendservice.controller;


import ro.societateahermes.backendservice.entities.dto.CDMemberDTO;
import ro.societateahermes.backendservice.exceptions.UnathorizeException;

import java.util.List;

public interface CDMemberControllerInterface {
    void saveCDMember(CDMemberDTO member) throws UnathorizeException;

    void deleteCDMember(Long CDMemberID) throws UnathorizeException;

    void updateCDMember(CDMemberDTO cdMemberDTO) throws UnathorizeException;

    List<CDMemberDTO> getAllCDMembers();
}
