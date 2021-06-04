package br.com.digitalhouse.springchallenge.domain;


import br.com.digitalhouse.springchallenge.dataprovider.DTO.PostDTO;
import br.com.digitalhouse.springchallenge.dataprovider.entity.Post;
import br.com.digitalhouse.springchallenge.dataprovider.entity.User;

import java.util.List;

public interface UserGateway {
    void followSeller (Long userId,Long sellerId);
    User getById (Long userId);
    List<PostDTO> getFeed(Long userId);
}
