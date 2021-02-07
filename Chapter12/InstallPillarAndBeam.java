package Chapter12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InstallPillarAndBeam {
    public static void main(String[] args) {
        int[][] build_frame1 = {
                {1, 0, 0, 1},
                {1, 1, 1, 1},
                {2, 1, 0, 1},
                {2, 2, 1, 1},
                {5, 0, 0, 1},
                {5, 1, 0, 1},
                {4, 2, 1, 1},
                {3, 2, 1, 1}
        };

        int[][] build_frame2 = {
                {0, 0, 0, 1},
                {2, 0, 0, 1},
                {4, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {2, 1, 1, 1},
                {3, 1, 1, 1},
                {2, 0, 0, 0},
                {1, 1, 1, 0},
                {2, 2, 0, 1}
        };

        solution(5, build_frame1);
    }

    static int[][] solution(int n, int[][] build_frame) {
        Structure s;
        for (int[] b : build_frame) {
            int x = b[0];
            int y = b[1];
            int type = b[2];
            int command = b[3];
            if (type==0) {
                s = new Pillar(x, y);
            }
            else {
                s = new Beam(x, y);
            }
            if (command==0) {
                StructureBox.remove(s);
            }
            else {
                StructureBox.install(s);
            }
        }
        for (Structure k : StructureBox.box) {
            System.out.println(k);
        }
        Collections.sort(StructureBox.box);

        int answer[][] = new int[StructureBox.box.size()][3];
        for (int i=0; i<StructureBox.box.size(); i++) {
            Structure c = StructureBox.box.get(i);
            answer[i][0] = c.x;
            answer[i][1] = c.y;
            answer[i][2] = c.type();
        }
        return answer;
    }
}

class StructureBox {
    static List<Structure> box = new ArrayList<>();

    static int index(int x, int y, int type) {
        for (int i=0; i<box.size(); i++) {
            Structure s = box.get(i);
            if (s.x==x && s.y==y) {
                if (s.type()==type) {
                    return i;
                }
            }
        }
        return -1;
    }

    static boolean possible() {
        for (Structure s: box) {
            if (s.type()==0) {
                if (!(s.y==0 || exist(s.x, s.y-1, 0))) {
                    if (!(exist(s.x-1, s.y, 1)||exist(s.x, s.y, 1))) {
                        return false;
                    }
                }
                if (!(exist(s.x-1, s.y, 1)||exist(s.x, s.y, 1))) {
                    if (!(s.y==0 || exist(s.x, s.y-1, 0))) {
                        return false;
                    }
                }
            }
            else {
                //pillar exists
                if (!(exist(s.x, s.y-1, 0) || exist(s.x+1, s.y-1, 0))) {
                    if (!(exist(s.x-1, s.y, 1) && exist(s.x+1, s.y, 1))) {
                        return false;
                    }
                }
                //beam exists
                else if (!(exist(s.x-1, s.y, 1) && exist(s.x+1, s.y, 1))) {
                    if (!(exist(s.x, s.y-1, 0) || exist(s.x+1, s.y-1, 0))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static void remove(Structure s) {
        int index = index(s.x, s.y, s.type());
        box.remove(index);
        if (!possible()) {
            box.add(s);
        }
    }

    static void add(Structure s) {
        box.add(s);
    }

    static void install(Structure s) {
        if (s.type()==0) {
            //pillar exists
            if (exist(s.x, s.y-1, 0) || s.y==0) {
                add(s);
            }
            //beam exists
            else if (exist(s.x-1, s.y, 1) || exist(s.x, s.y, 1)) {
                add(s);
            }
        }
        else {
            //pillar exists
            if (exist(s.x, s.y-1, 0) || exist(s.x+1, s.y-1, 0)) {
                add(s);
                System.out.println("beam: " + s.toString());
            }
            //beam exists
            else if (exist(s.x-1, s.y, 1) && exist(s.x+1, s.y, 1)) {
                add(s);
            }
        }
    }

    static boolean exist(int x, int y, int type) {
        for (Structure s : box) {
            if (s.x == x && s.y == y) {
                if (s.type() == type) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Structure implements Comparable<Structure> {
    int x; int y;
    public Structure(int x, int y) {
        this.x = x;
        this.y = y;
    }
    int type() {
        return -1;
    }

    @Override
    public String toString() {
        return "[" + x + "," + y + "," + type() + "]";
    }

    @Override
    public int compareTo(Structure s) {
        if (x!=s.x) {
            if (x>s.x) {
                return 1;
            }
            return -1;
        }
        if (y!=s.y) {
            if (y>s.y) {
                return 1;
            }
            return -1;
        }
        if (type()>s.type()) {
            return 1;
        }
        else if (type()<s.type()) {
            return -1;
        }
        return 0;
    }
}

class Beam extends Structure {
    public Beam(int x, int y) {
        super(x, y);
    }
    int type() {
        return 1;
    }
}

class Pillar extends Structure {
    public Pillar(int x, int y) {
        super(x, y);
    }
    int type() {
        return 0;
    }
}

