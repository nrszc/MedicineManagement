package henu.dao.IF;

import java.util.ArrayList;

import henu.bean.DaoJB;
import henu.bean.DaoMJB;
import henu.bean.DaoOrder;

public interface saleDaoIF {
    public DaoJB newsview(String salerNo);
    public DaoJB updatesaler(DaoJB jb);
    public ArrayList<DaoOrder> mysale(String salerNo);
    public boolean addmedicines(DaoMJB mjb);
    public String viewmedicines();
    public boolean delete(String mNo);
    public DaoMJB update(String mNo);
    public boolean addstaff(DaoJB jb);
    public String findstaff();
    public boolean deletestaff(String staffNo);
    public DaoJB updatestaff(String staffNo);
    public boolean updatestaff(DaoJB jb);
    public boolean addagency(DaoJB jb);
    public String findagency();
    public boolean deleteagency(String name);
    public DaoJB updateagency(String name);
    public boolean updateagency(DaoJB jb);
 
}
