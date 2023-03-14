package org.example;

import java.util.Objects;

public class major {
    public major() {
    }

    public static boolean IsValidTriangle(Integer SideA, Integer SideB, Integer SideC) {
        return SideA + SideB <= SideC || SideA + SideC <= SideB || SideB + SideC <= SideA;
    }

    public static String JudgeTheShapeOfTriangleBySides(Integer SideA, Integer SideB, Integer SideC) {
        if (IsValidTriangle(SideA, SideB, SideC)) return "INVALID";
        if (Objects.equals(SideA, SideB) && Objects.equals(SideB, SideC)) return "EQUILATERAL";
        else if (Objects.equals(SideA, SideB) && Objects.equals(SideB, SideC) && Objects.equals(SideA, SideC)) return "ISOSCELES";
        else return "SCALENE";
    }

    public static double GetTheAreaOfTriangleBySides(Integer SideA, Integer SideB, Integer SideC) {
        if (IsValidTriangle(SideA, SideB, SideC))  return 0;
        double average = (SideA+SideB+SideC)/2.0d;
        return Math.sqrt(average* (average - SideA) * (average - SideB) * (average - SideC));
    }
}
