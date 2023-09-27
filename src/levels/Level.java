package levels;

public class Level {
    private int [][] levelDatas;

    public Level(int[][] levelDatas){
        this.levelDatas = levelDatas;
    }
    public int getSpritesIndex(int x, int y){
        return levelDatas[y][x];
    }

    public int[][] getLevelDatas() {
        return levelDatas;
    }
}
