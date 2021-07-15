package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.CDMember;
import ro.societateahermes.backendservice.entities.DTO.CDMemberDTO;
import ro.societateahermes.backendservice.repository.CDMemberRepositoryInterface;
import ro.societateahermes.backendservice.service.CDMemberServiceInterface;

import java.util.List;

@Service
public class CDMemberServiceImplementation implements CDMemberServiceInterface {
    private final CDMemberRepositoryInterface CDMemberRepository;


    CDMemberServiceImplementation(CDMemberRepositoryInterface CDMemberRepo) {
        CDMemberRepository = CDMemberRepo;
    }

    @Override
    public void save(CDMember CDMember) {
        CDMemberRepository.save(CDMember);
    }

    @Override
    public List<CDMember> getAllCDMembers() {
        return CDMemberRepository.findAll();
    }

    @Override
    public void delete(Long CDMemberID) {
        for (CDMember cdMember : getAllCDMembers())
            if (CDMemberID.equals(cdMember.getCDMemberID()))
                CDMemberRepository.delete(cdMember);
    }

    @Override
    public void update(Long CDMemberID, CDMemberDTO cdMemberDTO) {
        CDMember updatedCDMember = CDMemberRepository.getOne(CDMemberID);
        updatedCDMember.setDescription(cdMemberDTO.getDescription());
        updatedCDMember.setName(cdMemberDTO.getName());
        updatedCDMember.setImagePath(cdMemberDTO.getImagePath());
        updatedCDMember.setPosition(cdMemberDTO.getPosition());
        CDMemberRepository.save(updatedCDMember);
    }
}
