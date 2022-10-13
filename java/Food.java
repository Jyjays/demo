public class Food {
    private int id;
    private String name;
    private String canteen;
    private int floor;


    public Food() {
    }

    public Food(int id, String name, String canteen, int floor) {
        this.id = id;
        this.name = name;
        this.canteen = canteen;
        this.floor = floor;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return canteen
     */
    public String getCanteen() {
        return canteen;
    }

    /**
     * 设置
     * @param canteen
     */
    public void setCanteen(String canteen) {
        this.canteen = canteen;
    }

    /**
     * 获取
     * @return floor
     */
    public int getFloor() {
        return floor;
    }

    /**
     * 设置
     * @param floor
     */
    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String toString() {
        return "Food{id = " + id + ", name = " + name + ", canteen = " + canteen + ", floor = " + floor + "}";
    }
}
