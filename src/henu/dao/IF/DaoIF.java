package henu.dao.IF;

import java.util.ArrayList;

import henu.bean.DaoCart;
import henu.bean.DaoJB;
import henu.bean.DaoMJB;
import henu.bean.DaoOrder;
import henu.factory.DaoFactory;

public interface DaoIF {
    public boolean register(DaoJB jb);
    public String login(DaoJB jb);
    public DaoJB updateuserview(String userNo);
    public DaoJB updateusernews(DaoJB jb);
    public ArrayList<DaoMJB> store();
    public DaoMJB details(String mNo);
    public boolean incart(DaoCart cart);
    public ArrayList<DaoCart> cartview(String userNo);
    public boolean deletecart(DaoCart cart);
    public ArrayList<DaoOrder> myorder(String userNo);
    public boolean buy(DaoOrder order);
    public boolean deleteorder(DaoOrder order);
}
