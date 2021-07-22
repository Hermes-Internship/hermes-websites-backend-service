package ro.societateahermes.backendservice.service.serviceImplementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.NewsFeedPost;
import ro.societateahermes.backendservice.entities.dto.NewsFeedDTO;
import ro.societateahermes.backendservice.entities.dto.UserDTO;
import ro.societateahermes.backendservice.repository.NewsFeedRepositoryInterface;
import ro.societateahermes.backendservice.service.NewsFeedServiceInterface;
import ro.societateahermes.backendservice.utils.mapper.NewsFeedMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsFeedServiceImplementation implements NewsFeedServiceInterface {

    private final NewsFeedRepositoryInterface newsFeedRepository;
    //private final NewsFeedMapper newsFeedMapper;
    private final ModelMapper modelMapper;

    public NewsFeedServiceImplementation(NewsFeedRepositoryInterface newsFeedRepository,ModelMapper modelMapper/*NewsFeedMapper newsFeedMapper*/){
        this.newsFeedRepository = newsFeedRepository;
        //this.newsFeedMapper = newsFeedMapper;
        this.modelMapper = modelMapper;
    }

    public List<NewsFeedDTO> getAllPost(){
        return newsFeedRepository.findAll().stream().map(post->modelMapper.map(post,NewsFeedDTO.class)).collect(Collectors.toList());
    }

    public void createPost(NewsFeedDTO newsFeedDTO){
        NewsFeedPost newsFeedPost = new NewsFeedPost();
        newsFeedPost.setPostDescription(newsFeedDTO.getPostDescription());
        newsFeedPost.setPostImagePath(newsFeedDTO.getPostImagePath());
        newsFeedPost.setPostLink(newsFeedDTO.getPostLink());
        newsFeedRepository.save(newsFeedPost);
    }
    public void deletePost(Long idPost){
        newsFeedRepository.delete(newsFeedRepository.findById(idPost).orElseThrow());
    }

}
