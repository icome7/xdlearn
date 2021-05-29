package com.iseven.learn.xdlearn.service;



import com.iseven.learn.xdlearn.model.po.VideoOrder;

import java.util.List;

public interface VideoOrderService {


    int save(int userId, int videoId);

    List<VideoOrder> listOrderByUserId(Integer userId);
}
