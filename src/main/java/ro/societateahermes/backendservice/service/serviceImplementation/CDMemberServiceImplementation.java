package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.cdMember.CDMember;
import ro.societateahermes.backendservice.entities.cdMember.Role;
import ro.societateahermes.backendservice.entities.dto.CDMemberDTO;
import ro.societateahermes.backendservice.repository.CDMemberRepositoryInterface;
import ro.societateahermes.backendservice.service.CDMemberServiceInterface;

import java.util.List;

@Service
public class CDMemberServiceImplementation implements CDMemberServiceInterface {
    private final CDMemberRepositoryInterface cdMemberRepository;


    CDMemberServiceImplementation(CDMemberRepositoryInterface cdMemberRepository) {
        this.cdMemberRepository = cdMemberRepository;
    }

    @Override
    public void save(CDMember CDMember) {
        cdMemberRepository.save(CDMember);
    }

    @Override
    public List<CDMember> getAllCDMembers() {
        return cdMemberRepository.findAll();
    }

    @Override
    public void delete(Long CDMemberID) {
        for (CDMember cdMember : getAllCDMembers())
            if (CDMemberID.equals(cdMember.getCDMemberID()))
                cdMemberRepository.delete(cdMember);
    }

    @Override
    public void update(CDMember cdMember) {
        CDMember updatedCDMember = cdMemberRepository.getOne(cdMember.getCDMemberID());
        updatedCDMember.setImagePath(cdMember.getImagePath());
        updatedCDMember.setFacebookLink(cdMember.getFacebookLink());
        updatedCDMember.setDescription(cdMember.getDescription());
        updatedCDMember.setName(cdMember.getName());
        updatedCDMember.setDepartmentId(cdMember.getDepartmentId());
        updatedCDMember.setRoleId(cdMember.getRoleId());
        cdMemberRepository.save(updatedCDMember);
    }

    public boolean isValidCdMember(CDMemberDTO cdMemberDTO) {
        if ((cdMemberDTO.getRoleType().equals(Role.VICE_PRESIDENT) || cdMemberDTO.getRoleType().equals(Role.MANAGER))
                && cdMemberDTO.getDepartmentId() == null) {
            return false;
        }

        return true;
    }
}
