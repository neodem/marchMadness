package com.neodem.madness.db;
import java.util.List;

import com.neodem.madness.db.beans.BaseVO;

public interface BaseDAO {
    public BaseVO findByID(Class clazz, Long id);
    
    public void save(BaseVO vo); 
    public void insert(BaseVO vo);    
    public void update(BaseVO vo);
    public void delete(BaseVO vo);
    public List findAll(Class clazz);
}
