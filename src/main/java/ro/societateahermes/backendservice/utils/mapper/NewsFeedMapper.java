package ro.societateahermes.backendservice.utils.mapper;

import ro.societateahermes.backendservice.entities.NewsFeedPost;
import ro.societateahermes.backendservice.entities.dto.NewsFeedDTO;

public class NewsFeedMapper {

    public NewsFeedDTO convertToDTO(NewsFeedPost newsFeedPost){
        NewsFeedDTO newsFeedDTO = new NewsFeedDTO();
        newsFeedDTO.setPostDescription(newsFeedPost.getPostDescription());
        newsFeedDTO.setPostImagePath(newsFeedDTO.getPostImagePath());
        newsFeedDTO.setPostLink(newsFeedPost.getPostLink());

        return newsFeedDTO;
    }

    public NewsFeedPost convertToEntity(NewsFeedDTO newsFeedDTO){
        NewsFeedPost newsFeedPost = new NewsFeedPost();
        newsFeedPost.setPostDescription(newsFeedDTO.getPostDescription());
        newsFeedPost.setPostImagePath(newsFeedDTO.getPostImagePath());
        newsFeedPost.setPostLink(newsFeedDTO.getPostLink());

        return newsFeedPost;
    }
}
