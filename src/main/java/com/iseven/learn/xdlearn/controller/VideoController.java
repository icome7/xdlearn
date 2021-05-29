package com.iseven.learn.xdlearn.controller;

import com.iseven.learn.xdlearn.util.ResultData;
import com.iseven.learn.xdlearn.model.po.Video;
import com.iseven.learn.xdlearn.model.po.VideoBanner;
import com.iseven.learn.xdlearn.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/pub/video")
public class VideoController {


    @Autowired
    private VideoService videoService;


    /**
     * 轮播图列表
     * @return
     */
    @GetMapping("list_banner")
    public ResultData indexBanner(){


        List<VideoBanner> bannerList =  videoService.listBanner();



        return ResultData.success(bannerList);

    }


    /**
     * 视频列表
     * @return
     */
    @RequestMapping("list")
    public ResultData listVideo(){

        List<Video> videoList = videoService.listVideo();
        return ResultData.success(videoList);
    }


    /**
     * 查询视频详情，包含章，集信息
     * @param videoId
     * @return
     */
    @GetMapping("find_detail_by_id")
    public ResultData findDetailById(@RequestParam(value = "video_id",required = true)int videoId){




        Video video = videoService.findDetailById(videoId);

        return ResultData.success(video);

    }






}
