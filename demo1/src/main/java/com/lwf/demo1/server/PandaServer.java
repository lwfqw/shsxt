package com.lwf.demo1.server;

import com.lwf.demo1.dao.PandaDao;
import com.lwf.demo1.pojo.Panda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lwf
 * @title: PandaServer
 * @projectName demo1
 * @description: TODO
 * @date 2020/10/2821:18
 */
@Service
public class PandaServer {
    @Autowired
    @SuppressWarnings("all")
    private PandaDao pandaDao;
    public List<Panda> allPanda(){return pandaDao.allPanda();}
    public boolean insert(Panda panda){return pandaDao.insert(panda);}
    public boolean delete(String name){return pandaDao.delete(name);}
}
