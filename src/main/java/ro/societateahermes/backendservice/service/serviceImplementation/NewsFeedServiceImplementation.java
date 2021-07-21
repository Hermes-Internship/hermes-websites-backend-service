package ro.societateahermes.backendservice.service.serviceImplementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.NewsFeedPost;
import ro.societateahermes.backendservice.entities.dto.NewsFeedDTO;
import ro.societateahermes.backendservice.repository.NewsFeedRepositoryInterface;
import ro.societateahermes.backendservice.service.NewsFeedServiceInterface;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsFeedServiceImplementation implements NewsFeedServiceInterface {

    private final NewsFeedRepositoryInterface newsFeedRepository;
    private final ModelMapper modelMapper;

    public NewsFeedServiceImplementation(NewsFeedRepositoryInterface newsFeedRepository,ModelMapper modelMapper){
        this.newsFeedRepository = newsFeedRepository;
        this.modelMapper = modelMapper;
    }

    public List<NewsFeedDTO> getAllPost(){
        return newsFeedRepository.findAll().stream().map(post->modelMapper.map(post,NewsFeedDTO.class)).collect(Collectors.toList());
    }

    public void createPost(NewsFeedPost newsFeedPost){
        newsFeedRepository.save(newsFeedPost);
    }

    public void deletePost(Long idPost){
        newsFeedRepository.delete(newsFeedRepository.findById(idPost).orElseThrow());
    }

}
