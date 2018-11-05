package bean;

import java.util.List;

public class Datas {
    private int flag = 1;
    private int count = 0;
    private List<String> datas = null;

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getFlag() {
        return flag;
    }

    public void setDatas(List<String> datas) {
        this.datas = datas;
    }
    public void addData(String title){
        this.datas.add(title);
    }
    public List<String> getDatas() {
        return datas;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
