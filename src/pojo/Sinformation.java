package pojo;

public class Sinformation {
    private String guanxi;
    private  String name;
    private  String uID;
    private  String number;
//    门户
    private  String youbianma;
    private String daimahao;
    private String pinkun;
    private String paichusuo;
    private String sheng;
    private  String shi;
    private  String qu;
    private  String jiedao;

    public String getGuanxi() {
        return guanxi;
    }

    public void setGuanxi(String guanxi) {
        this.guanxi = guanxi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getYoubianma() {
        return youbianma;
    }

    public void setYoubianma(String youbianma) {
        this.youbianma = youbianma;
    }

    public String getDaimahao() {
        return daimahao;
    }

    public void setDaimahao(String daimahao) {
        this.daimahao = daimahao;
    }

    public String getPinkun() {
        return pinkun;
    }

    public void setPinkun(String pinkun) {
        this.pinkun = pinkun;
    }

    public String getPaichusuo() {
        return paichusuo;
    }

    public void setPaichusuo(String paichusuo) {
        this.paichusuo = paichusuo;
    }

    public String getSheng() {
        return sheng;
    }

    public void setSheng(String sheng) {
        this.sheng = sheng;
    }

    public String getShi() {
        return shi;
    }

    public void setShi(String shi) {
        this.shi = shi;
    }

    public String getQu() {
        return qu;
    }

    public void setQu(String qu) {
        this.qu = qu;
    }

    public String getJiedao() {
        return jiedao;
    }

    public void setJiedao(String jiedao) {
        this.jiedao = jiedao;
    }

    @Override
    public String toString() {
        return "Sinformation{" +
                "guanxi='" + guanxi + '\'' +
                ", name='" + name + '\'' +
                ", uID='" + uID + '\'' +
                ", number='" + number + '\'' +
                ", youbianma='" + youbianma + '\'' +
                ", daimahao='" + daimahao + '\'' +
                ", pinkun='" + pinkun + '\'' +
                ", paichusuo='" + paichusuo + '\'' +
                ", sheng='" + sheng + '\'' +
                ", shi='" + shi + '\'' +
                ", qu='" + qu + '\'' +
                ", jiedao='" + jiedao + '\'' +
                '}';
    }
}
