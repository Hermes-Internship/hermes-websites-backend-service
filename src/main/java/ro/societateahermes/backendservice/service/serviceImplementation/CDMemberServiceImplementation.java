package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.CDMember;
import ro.societateahermes.backendservice.entities.DTO.CDMemberDTO;
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
    public void update(Long CDMemberID, CDMember cdMember) {
        CDMember updatedCDMember = cdMemberRepository.getOne(CDMemberID);
        updatedCDMember.setImagePath(cdMember.getImagePath());
        updatedCDMember.setFacebookLink(cdMember.getFacebookLink());
        updatedCDMember.setDescription(cdMember.getDescription());
        updatedCDMember.setName(cdMember.getName());
        updatedCDMember.setPosition(cdMember.getPosition());
        cdMemberRepository.save(updatedCDMember);
    }

}
