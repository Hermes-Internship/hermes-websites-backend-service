package ro.societateahermes.backendservice.service.serviceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.dto.OfferDTO;
import ro.societateahermes.backendservice.repository.OfferRepositoryInterface;
import ro.societateahermes.backendservice.service.OfferServiceInterface;
import ro.societateahermes.backendservice.utils.mapper.OfferMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class OfferServiceImplementation implements OfferServiceInterface {
    private OfferMapper  offerMapper;
    private OfferRepositoryInterface offerRepository;
    @Autowired
    public OfferServiceImplementation(OfferRepositoryInterface offerRepository, OfferMapper offerMapper) {
        this.offerRepository = offerRepository;
        this.offerMapper = offerMapper;
    }

    @Override
    public List<OfferDTO> getAll() {
        return offerRepository.findAll().stream().map(offer -> offerMapper.convertToDTO(offer)).collect(Collectors.toList());
    }

    @Override
    public void save(OfferDTO offerDTO) {
        offerRepository.save(offerMapper.convertToOffer(offerDTO));
    }

    @Override
    public void delete(Long offerId) {
        offerRepository.delete(offerRepository.getOne(offerId));

    }
}
