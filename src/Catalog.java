import java.util.*;

public class Catalog {
    public static void main(String[] args) {
        String str = "K1\\SK2\n" +
                "K1\\SK1\n" +
                "K1\\SK1\\SSK1\n" +
                "K1\\SK1\\SSK2\n" +
                "K2\n" +
                "K2\\SK1\\SSK1\n" +
                "K2\\SK1\\SSK2";

        String[] mas = str.split("\n");

        List<String> allDep = new ArrayList<>();
        int max = 0;
        for (String dep : mas) {
            String[] tempMas = dep.split("\\\\");
            String tempName = tempMas[0];
            max = max > tempMas.length ? max : tempMas.length;

            if (!allDep.contains(tempName)) allDep.add(tempName);

            for (int i = 1; i < tempMas.length; i++) {
                tempName += "\\" + tempMas[i];
                if (!allDep.contains(tempName)) allDep.add(tempName);
            }
        }

        for (int i = 0; i < max; i++) {
            int finalI = i;
            allDep.sort((o1, o2) -> {
                int ii = finalI;
                String[] tempO1 = o1.split("\\\\");
                String[] tempO2 = o2.split("\\\\");
                if (tempO1.length >= ii + 1 && tempO2.length >= ii + 1)
                    return tempO2[ii].compareTo(tempO1[ii]);
                else
                    return tempO2[0].compareTo(tempO1[0]);
            });
        }

        System.out.println(allDep);
    }
}
