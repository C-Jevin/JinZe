package com.jinze.service;
import com.jinze.entity.Landtypes;
import com.jinze.core.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2019/09/16.
 */
public interface LandtypesService extends Service<Landtypes> {
    Map selectUsedLandPercentage(Map map);
}
