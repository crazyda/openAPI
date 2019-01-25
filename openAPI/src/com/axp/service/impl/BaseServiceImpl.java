package com.axp.service.impl;import java.lang.reflect.Field;import java.lang.reflect.ParameterizedType;import java.util.List;import javax.annotation.PostConstruct;import org.springframework.beans.factory.annotation.Autowired;import com.axp.dao.AgentDAO;import com.axp.dao.IBaseDao;import com.axp.dao.MoneyDAO;import com.axp.dao.OpenClassifyDAO;import com.axp.dao.OpenClientDAO;import com.axp.dao.OpenGoods2DAO;import com.axp.dao.OpenGoodsAll2DAO;import com.axp.dao.OpenGoodsAllDAO;import com.axp.dao.OpenGoodsCurrentDAO;import com.axp.dao.OpenGoodsDAO;import com.axp.dao.OpenJDClassifyDAO;import com.axp.dao.OpenJDCoponGoods2DAO;import com.axp.dao.OpenJDCoponGoodsDAO;import com.axp.dao.OpenJDGoods2DAO;import com.axp.dao.OpenJDGoodsDAO;import com.axp.dao.OpenJDOrederListDAO;import com.axp.dao.OpenJDQueryCoponGoods2DAO;import com.axp.dao.OpenJDQueryCoponGoodsDAO;import com.axp.dao.OpenJDQueryExplosiveGoods2DAO;import com.axp.dao.OpenJDQueryExplosiveGoodsDAO;import com.axp.dao.OpenPddGoodsDAO;import com.axp.dao.OpenPddIncrementGoods2DAO;import com.axp.dao.OpenPddIncrementGoodsDAO;import com.axp.dao.OpenPddIncrementGoodsHistoryDAO;import com.axp.dao.OpenPddPromotionUrlDAO;import com.axp.dao.OpenThemeDAO;import com.axp.dao.OpenThemeGoodsDAO;import com.axp.dao.PidRelationDAO;import com.axp.dao.UsersOperationRecordDao;import com.axp.service.IBaseService;import com.axp.service.OpenJDQueryCoponGoodsService;import com.axp.dao.OpenAppDAO;public class BaseServiceImpl<T> implements IBaseService<T> {   @Autowired   public OpenClientDAO openClientDAO;      @Autowired   public OpenGoodsDAO openGoodsDAO;     @Autowired   public OpenGoods2DAO openGoods2DAO;     @Autowired   public OpenGoodsCurrentDAO openGoodsCurrentDAO;    @Autowired   public AgentDAO agentDAO;     @Autowired   public OpenAppDAO openAppDAO;    @Autowired   public PidRelationDAO pidRelationDAO;   @Autowired   public OpenPddGoodsDAO openPddGoodsDAO;   @Autowired   public MoneyDAO moneyDAO;     @Autowired  public OpenPddPromotionUrlDAO openPddPromotionUrlDAO;  @Autowired  public OpenPddIncrementGoodsDAO openPddIncrementGoodsDAO;  @Autowired  public OpenPddIncrementGoods2DAO openPddIncrementGoods2DAO;  @Autowired  public OpenPddIncrementGoodsHistoryDAO openPddIncrementGoodsHistoryDAO;  @Autowired  public UsersOperationRecordDao usersOperationRecordDAO;  @Autowired  public OpenClassifyDAO openClassifyDAO;    @Autowired  public OpenThemeDAO openThemeDAO;    @Autowired  public OpenThemeGoodsDAO openThemeGoodsDAO;  @Autowired  public OpenJDClassifyDAO openJDClassifyDAO;  @Autowired  public OpenJDGoodsDAO openJDGoodsDAO;  @Autowired  public OpenJDGoods2DAO openJDGoods2DAO;    @Autowired  public OpenJDQueryCoponGoodsDAO openJDQueryCoponGoodsDAO;    @Autowired  public OpenJDQueryCoponGoods2DAO openJDQueryCoponGoods2DAO;    @Autowired  public OpenJDQueryExplosiveGoodsDAO openJDQueryExplosiveGoodsDAO;  @Autowired  public OpenJDQueryExplosiveGoods2DAO openJDQueryExplosiveGoods2DAO;  @Autowired  public OpenJDCoponGoods2DAO openJDCoponGoods2DAO;  @Autowired  public OpenJDCoponGoodsDAO openJDCoponGoodsDAO;  @Autowired  public OpenJDOrederListDAO openJDOrederListDAO;  @Autowired   public OpenGoodsAllDAO openGoodsAllDAO;   @Autowired   public OpenGoodsAll2DAO openGoodsAll2DAO;    	public IBaseDao<T> baseDao;	public static final int pageItemCount = 10;	public static final int pageSize = 20;	@SuppressWarnings("unchecked")	@PostConstruct	public void init() {		try {			ParameterizedType genericSuperclass = (ParameterizedType) this					.getClass().getGenericSuperclass();			Class<T> clazz = (Class<T>) genericSuperclass					.getActualTypeArguments()[0];			String simpleName = clazz.getSimpleName();// Employee			// employee+Dao			String daoName = simpleName.substring(0, 1).toLowerCase()					+ simpleName.substring(1) + "DAO";// employeeDao			Field daoField = this.getClass().getField(daoName);						Object object = daoField.get(this);			Field baseDaoField = this.getClass().getField("baseDao");			baseDaoField.set(this, object);		} catch (Exception e) {			e.printStackTrace();		}	}	@Override	public void save(T t) {		baseDao.save(t);	}	@Override	public void update(T t) {		baseDao.update(t);	}	@Override	public void delete(T t) {		baseDao.delete(t);	}	@Override	public List<T> queryAll() {		return baseDao.queryAll();	}	@Override	public T get(Integer id) {		return baseDao.get(id);	}	}