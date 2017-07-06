package com.sun.beans;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import com.sun.dao.UserMapper;
import com.sun.model.User;

/*
 * 监听器，用于项目启动的时候初始化信息
 */
@Service
public class StartAddCacheListener implements ApplicationListener<ContextRefreshedEvent>
{
	@Resource
    private RedisCacheUtil<Object> redisCache;
    

	@Resource
	private UserMapper userMapper;
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent  event) 
    { 
        //spring 启动的时候缓存user等信息
        if(event.getApplicationContext().getParent() == null)
        {
            System.out.println("\n\n\n_________\n\n缓存数据 \n\n ________\n\n\n\n");
            List<User> userList = userMapper.selectAll();
            
            Map<Integer,User> userMap = new HashMap<Integer,User>();
            
            int cityListSize = userList.size();
            
            for(int i = 0 ; i < cityListSize ; i ++ )
            {
                userMap.put(userList.get(i).getId(), userList.get(i));
            }
            
            
            redisCache.setCacheIntegerMap("userMap", userMap);
        }
    }
    
}
