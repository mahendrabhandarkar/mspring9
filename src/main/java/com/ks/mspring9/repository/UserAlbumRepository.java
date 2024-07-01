package com.ks.mspring9.repository;

import com.ks.mspring9.entity.UserAlbum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserAlbumRepository extends JpaRepository<UserAlbum, Integer>, JpaSpecificationExecutor<UserAlbum> {

}