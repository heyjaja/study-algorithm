package basic.search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhysExamSearch {

    static class PhyData {
        private String name; // 이름
        private int height; // 키
        private double vision; // 시력

        public PhyData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        public PhyData(int height) {
            this.height = height;
        }

        public PhyData(double vision) {
            this.vision = vision;
        }

        public PhyData(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "name='" + name + '\'' +
                    ", height=" + height +
                    ", vision=" + vision;
        }
    }

    public static void main(String[] args) {
        PhyData[] x = {
                new PhyData("권유리", 158, 0.2),
                new PhyData("김태연", 160, 0.3),
                new PhyData("김효연", 161, 0.5),
                new PhyData("서주현", 163, 0.6),
                new PhyData("이순규", 166, 0.9),
                new PhyData("임윤아", 167, 1.0),
                new PhyData("최수영", 169, 1.2),
                new PhyData("황미영", 171, 1.5),
        };

        Scanner sc = new Scanner(System.in);

        System.out.print("키 검색: ");
        int height = sc.nextInt();

        int heightResult = Arrays.binarySearch(
                x, new PhyData(height),
                Comparator.comparingInt(o -> o.height));

        if(heightResult >= 0) {
            System.out.println("x["+ heightResult +"] = " + x[heightResult]);
        } else {
            System.out.println("해당 키를 가진 사람은 없습니다.");
        }

        System.out.print("시력 검색: ");
        double vision = sc.nextDouble();

        int visionResult = Arrays.binarySearch(
                x, new PhyData(vision),
                Comparator.comparingDouble(o -> o.vision));

        if(visionResult >= 0) {
            System.out.println("x["+ visionResult +"] = " + x[visionResult]);
        } else {
            System.out.println("해당 시력을 가진 사람은 없습니다.");
        }

        System.out.print("이름 검색: ");
        String name = sc.next();

        int nameResult = Arrays.binarySearch(
                x, new PhyData(name),
                Comparator.comparing(o -> o.name));

        if(nameResult >= 0) {
            System.out.println("x["+ nameResult +"] = " + x[nameResult]);
        } else {
            System.out.println("해당 이름을 가진 사람은 없습니다.");
        }
    }
}
