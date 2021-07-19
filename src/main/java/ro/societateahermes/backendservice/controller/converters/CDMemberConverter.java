package ro.societateahermes.backendservice.controller.converters;

import ro.societateahermes.backendservice.entities.CDMember;
import ro.societateahermes.backendservice.entities.DTO.CDMemberDTO;

public class CDMemberConverter {
    public static CDMemberDTO cdMemberToCDMemberDTO(CDMember cdMember) {
        if (cdMember == null) return null;
        CDMemberDTO cdMemberDTO = new CDMemberDTO();
        cdMemberDTO.setId(cdMember.getCDMemberID());
        cdMemberDTO.setImagePath(cdMember.getImagePath());
        cdMemberDTO.setFacebookLink(cdMember.getFacebookLink());
        cdMemberDTO.setName(cdMember.getName());
        cdMemberDTO.setDescription(cdMember.getDescription());
        cdMemberDTO.setPosition(cdMember.getPosition());
        return cdMemberDTO;
    }

    public static CDMember cdMemberDTOToCDMember(CDMemberDTO cdMemberDTO) {
        if (cdMemberDTO == null) return null;
        CDMember cdMember = new CDMember();
        cdMember.setCDMemberID(cdMemberDTO.getId());
        cdMember.setImagePath(cdMemberDTO.getImagePath());
        cdMember.setFacebookLink(cdMemberDTO.getFacebookLink());
        cdMember.setName(cdMemberDTO.getName());
        cdMember.setDescription(cdMemberDTO.getDescription());
        cdMember.setPosition(cdMemberDTO.getPosition());
        return cdMember;
    }
}
