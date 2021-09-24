public class Operations {

    private String name;
    private int coming;
    private int expenditure;

    public Operations(String name, Integer coming, Integer expenditure) {
        this.name = name;
        this.coming = coming;
        this.expenditure = expenditure;
    }

    protected void setName(String name) {
        this.name += name;
    }

    protected String getName() {
        return this.name;
    }

    protected void setComing(Integer coming) {
        this.coming += coming;
    }

    protected int getComing() {
        return this.coming;
    }

    protected void setExpenditure(Integer expenditure) {
        this.expenditure += expenditure;
    }

    protected int getExpenditure() {
        return this.expenditure;
    }
}
