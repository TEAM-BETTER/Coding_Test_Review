import java.util.HashSet;
import java.util.Objects;

class Solution {
    public int solution(String dirs) {
        HashSet<Path> paths = new HashSet<>();

        Position cur = new Position();
        Position next;
        // dirs.toCharArray => ['U', 'D', 'L' ...] 형식
        // dir = 'U' || 'D' || 'L' || 'R'
        for(char dir : dirs.toCharArray()) {
            next = new Position(cur);
            // dir의 값을 검사하여 next 좌표를 만들어준다.
            // 이때 set함수에는 범위값이 -5 ~ 5사이가 아닐경우 현재 값을 유지한다.
            switch (dir){
                case 'U':
                    next.setX(next.getX() - 1);
                    break;
                case 'D':
                    next.setX(next.getX() + 1);
                    break;
                case 'L':
                    next.setY(next.getY() - 1);
                    break;
                case 'R':
                    next.setY(next.getY() + 1);
                    break;
            }
            // 범위값을 넘어간 좌표가 있어서 값이 유지 된다면 넘어간다
            if (cur.equals(next)) continue;
            // 경로를 만들어서 넣어주고 cur를 최신화 해 준다.
            Path path = new Path(cur, next);
            paths.add(path);
            cur = next;
        }

        return paths.size();
    }
}

// 경로를 나타내는 클래스
class Path {
    Position from; //(x1, y1)
    Position to; //(x2, y2)

    public Path(Position from, Position to) {
        this.from = from;
        this.to = to;
    }

    /*
    *  HashSet에서 같은 객체를 판단하는 조건을 만들어 주기 위해서 equals와 hashCode 오버라이드
    *  (from = from and to = to) + (from = to and to = from) 출발점 종점 상관없이 한 쌍이 같으면 같다고 판단 할 수 있도록 오버라이드
    * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Path path = (Path) o;
        return (Objects.equals(from, path.from) && Objects.equals(to, path.to)) || (Objects.equals(from, path.to) && Objects.equals(to, path.from));
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to) + Objects.hash(to,from);
    }
}

// x,y 좌표를 나타내는 클래스
class Position {
    private int x;
    private int y;

    public Position() {
        this.x = 0;
        this.y = 0;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(Position pos) {
        this.x = pos.getX();
        this.y = pos.getY();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x < -5 || x > 5) return;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (y < -5 || y > 5) return;
        this.y = y;
    }

    /*
    *  Path 객체의 유일성을 판단하기 위한 보조로직
    *  x,y 좌표 값이 모두 같으면 같게 오버라이드함
    * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}