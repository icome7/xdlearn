package com.iseven.learn.xdlearn.mapper;

import com.iseven.learn.xdlearn.model.po.Episode;
import org.apache.ibatis.annotations.Param;

public interface EpisodeMapper {


    Episode findFirstEpisodeByVideoId(@Param("video_id") int videoId);

}
