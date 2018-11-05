package dao;

import bean.Datas;
import bean.News;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsDao {
    public void addNews(News news){
        String sql = "INSERT INTO news(`id`, `title`)  VALUES(NULL,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, news.getTitle());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addNews(String title){
        String sql = "INSERT INTO news(`id`, `title`)  VALUES(NULL,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, title);

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Datas get(int pageIndex,int numsPerPage){
        List<News> newsList = new ArrayList<>();
        Datas datas = new Datas();
        List<String> strings = new ArrayList<>();
        String sql = "SELECT * FROM `news` ";

        try (Connection c = DBUtil.getConnection(); Statement st = c.createStatement()){
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                strings.add(rs.getString("title"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        int indexBeg = (pageIndex-1)*numsPerPage;

        List<String> buf = null;
        if (indexBeg+numsPerPage>strings.size()){
            buf = strings.subList(indexBeg,strings.size()-1);
        }else {
            buf = strings.subList(indexBeg,indexBeg+numsPerPage);
        }

        datas.setCount(strings.size());
        datas.setDatas(buf);
        return datas;
    }

}
