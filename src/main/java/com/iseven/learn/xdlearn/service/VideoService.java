package com.iseven.learn.xdlearn.service;

import com.iseven.learn.xdlearn.model.po.Video;
import com.iseven.learn.xdlearn.model.po.VideoBanner;

import java.util.List;

public interface VideoService {

    List<Video> listVideo();

    List<VideoBanner> listBanner();

    Video findDetailById(int videoId);
}
