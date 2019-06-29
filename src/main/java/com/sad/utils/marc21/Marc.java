package com.sad.utils.marc21;

import java.util.ArrayList;

public class Marc {

    private static final String mA = "$$a";
    private static final String mB = "$$b";
    private static final String mC = "$$c";
    private static final String mD = "$$d";
    private static final String mE = "$$e";
    private static final String mF = "$$f";
    private static final String mG = "$$g";
    private static final String mH = "$$h";
    private static final String mI = "$$i";
    private static final String mJ = "$$j";
    private static final String mK = "$$k";
    private static final String mN = "$$n";
    private static final String mP = "$$p";
    private static final String mS = "$$s";
    private static final String mM = "$$m";
    private static final String mQ = "$$q";
    private static final String m2 = "$$2";
    private static final String m3 = "$$3";
    private static final String m6 = "$$6";
    private static final String m8 = "$$8";
    private static final String mL = "$$l";
    private static final String mT = "$$t";
    private static final String mU = "$$u";
    private static final String mX = "$$x";
    private static final String mZ = "$$z";
    private static final String m4 = "$$4";
    private static final String m0 = "$$0";
    private static final String sp = "  ";

    private static final String fi005 = "005  L";
    private static final String fi927 = "927  L";

    private static ArrayList<String> fi082() {
        String z = "082";
        String x = "L";
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(z + "0 " + x);
        arrayList.add(z + "00" + x);
        arrayList.add(z + "04" + x);
        arrayList.add(z + "1 " + x);
        arrayList.add(z + "10" + x);
        arrayList.add(z + "14" + x);
        arrayList.add(z + "7 " + x);
        arrayList.add(z + "70" + x);
        arrayList.add(z + "74" + x);

        return arrayList;
    }

    private static ArrayList<String> fi245() {
        ArrayList<String> arrayList = new ArrayList<>();
        String z = "245";
        String x = "L";
        arrayList.add(z + "  " + x);
        arrayList.add(z + " 0" + x);
        arrayList.add(z + " 1" + x);
        arrayList.add(z + " 2" + x);
        arrayList.add(z + " 3" + x);
        arrayList.add(z + " 4" + x);
        arrayList.add(z + " 5" + x);
        arrayList.add(z + " 6" + x);
        arrayList.add(z + " 7" + x);
        arrayList.add(z + " 8" + x);
        arrayList.add(z + " 9" + x);
        arrayList.add(z + "0 " + x);
        arrayList.add(z + "01" + x);
        arrayList.add(z + "02" + x);
        arrayList.add(z + "03" + x);
        arrayList.add(z + "04" + x);
        arrayList.add(z + "05" + x);
        arrayList.add(z + "06" + x);
        arrayList.add(z + "07" + x);
        arrayList.add(z + "08" + x);
        arrayList.add(z + "09" + x);
        arrayList.add(z + "10" + x);
        arrayList.add(z + "11" + x);
        arrayList.add(z + "12" + x);
        arrayList.add(z + "13" + x);
        arrayList.add(z + "14" + x);
        arrayList.add(z + "15" + x);
        arrayList.add(z + "16" + x);
        arrayList.add(z + "17" + x);
        arrayList.add(z + "18" + x);
        arrayList.add(z + "19" + x);
        arrayList.add(z + "1 " + x);
        arrayList.add(z + "00" + x);
        return arrayList;
    }

    private static ArrayList<String> fi260() {
        ArrayList<String> arrayList = new ArrayList<>();
        String z = "260";
        String x = "L";
        arrayList.add(z + "  " + x);
        arrayList.add(z + "2 " + x);
        arrayList.add(z + "3 " + x);
        return arrayList;
    }

    private static ArrayList<String> fi852() {
        ArrayList<String> arrayList = new ArrayList<>();
        String a = "852";
        String x = "L";
        arrayList.add(a + "  " + x);
        arrayList.add(a + " 0" + x);
        arrayList.add(a + " 1" + x);
        arrayList.add(a + " 2" + x);
        arrayList.add(a + "1 " + x);
        arrayList.add(a + "10" + x);
        arrayList.add(a + "11" + x);
        arrayList.add(a + "12" + x);
        arrayList.add(a + "2 " + x);
        arrayList.add(a + "20" + x);
        arrayList.add(a + "21" + x);
        arrayList.add(a + "22" + x);
        arrayList.add(a + "3 " + x);
        arrayList.add(a + "30" + x);
        arrayList.add(a + "31" + x);
        arrayList.add(a + "32" + x);
        arrayList.add(a + "4 " + x);
        arrayList.add(a + "40" + x);
        arrayList.add(a + "41" + x);
        arrayList.add(a + "42" + x);
        arrayList.add(a + "5 " + x);
        arrayList.add(a + "50" + x);
        arrayList.add(a + "51" + x);
        arrayList.add(a + "52" + x);
        arrayList.add(a + "6 " + x);
        arrayList.add(a + "60" + x);
        arrayList.add(a + "61" + x);
        arrayList.add(a + "62" + x);
        arrayList.add(a + "7 " + x);
        arrayList.add(a + "70" + x);
        arrayList.add(a + "71" + x);
        arrayList.add(a + "72" + x);
        arrayList.add(a + "8 " + x);
        arrayList.add(a + "80" + x);
        arrayList.add(a + "81" + x);
        arrayList.add(a + "82" + x);
        return arrayList;
    }

    private static ArrayList<String> fi916() {
        ArrayList<String> arrayList = new ArrayList<>();
        String a = "916";
        String x = "L";
        arrayList.add(a + "  " + x);
        arrayList.add(a + "00" + x);
        return arrayList;
    }

    private static ArrayList<String> sp005(String data) {
        //0008FMT  LBK0030LDR  L00695nam^a2200265^p^45000015001  L0000301490011003  L364940019005  L20173101029.00046008  L170310s2011^^^^vm^^^^^^^^^^^^000^^^vie^^0013040  L$$aLTDT0012041  L$$avie00421001 L$$aBùi, Duy Khánh,$$eđạo diễn012024510L$$aKhám phá Việt Nam,$$nT.27,$$pĐỉnh Tây Côn Lĩnh :$$bPhim tài liệu /$$cĐạo diễn Bùi Duy Khánh0050260  L$$aViệt Nam :$$bDolphinMedia ; VTV,$$c20110017300  L$$a15 min ;0031347  L$$b.flv.$$c40.4 Mb.$$2rda0019653  L$$aViệt Nam0020653  L$$aĐịa danh0023653  L$$aĐất nước0018653  L$$aDu lịch0025916  L$$aPhim tài liệu0038916  L$$aĐất nước - con người0007925  LF0007926  L00008927  LFM0012OWN  L$$aTDT0032CAT  L$$c20170310$$lTDT01$$h15380045CAT  L$$aBATCH$$b00$$c20170311$$lTDT01$$h13430032CAT  L$$c20170411$$lTDT01$$h16290045CAT  L$$aBATCH$$b00$$c20170421$$lTDT01$$h17210032CAT  L$$c20170623$$lTDT01$$h13380032CAT  L$$c20170627$$lTDT01$$h10250032CAT  L$$c20170627$$lTDT01$$h11170017911  LTo Minh Kha
        ArrayList<String> a = new ArrayList<>();
        if (data.contains(fi005)) {
            data = data.substring(data.indexOf(fi005) + 6);
            data = data.substring(0, 8);
            a.add(data.substring(0, 4));
            a.add(data.substring(4, 6));
            a.add(data.substring(6, 8));
        } else {
            data = null;
            a.add(data);
        }
        return a;
    }

    private static ArrayList<String> sp082(String data) {
        ArrayList<String> s082 = new ArrayList<>();
        String cn082 = null;
        String in082 = null;
        int i = 0;
        for (String f : fi082()) {
            if (data.indexOf(f) > 0) {
                i = data.indexOf(f);
            }
        }
        if (i == 0) {
            cn082 = null;
            in082 = null;
        } else {
            data = data.substring(i+5);
            data = data.substring(0, i);
            if (data.indexOf(mQ) > 0) {
                i = data.indexOf(mQ);
                data = data.substring(0, i);
            } else if (data.indexOf(mM) > 0) {
                i = data.indexOf(mM);
                data = data.substring(0, i);
            } else if (data.indexOf(m2) > 0) {
                i = data.indexOf(m2);
                data = data.substring(0, i);
            } else if (data.indexOf(m6) > 0) {
                i = data.indexOf(m6);
                data = data.substring(0, i);
            } else if (data.indexOf(m8) > 0) {
                i = data.indexOf(m8);
                data = data.substring(0, i);
            }
            if (data.contains(mA) && data.contains(mB)) {
                i = data.indexOf(mB);
                in082 = data.substring(i + 3);
                if (in082.contains("L$$")){
                    in082 = in082.substring(0,in082.indexOf("L$$")-7);
                }
                cn082 = data.substring(4, i);
            } else if (!data.contains(mA) && data.contains(mB)) {
                i = data.indexOf(mB);
                in082 = data.substring(4);
                cn082 = null;
            } else {
                if (data.length() > 5) {
                    cn082 = data.substring(4);
                    in082 = null;
                } else {
                    cn082 = null;
                    in082 = null;
                }

            }
        }
        s082.add(cn082);
        s082.add(in082);
        return s082;
    }

    private static ArrayList<String> sp245(String data) {
        ArrayList<String> s245 = new ArrayList<>();
        int i = 0;
        String title;
        String author = null;

        for (String f : fi245()) {
            if (data.indexOf(f) > 0) {
                i = data.indexOf(f);
            }
        }
        data = data.substring(i + 6);
        data = data.substring(3, data.indexOf(sp) - 7);

        if (data.contains(mC)) {
            author = data.substring(data.indexOf(mC) + 3);
            if (author.contains("$$")) {
                author = author.substring(0, author.indexOf("$$"));
            }
        }

        title = data.replace(mC + author, " ");

        if (data.contains(mA)) {
            title = title.replace(mA, "");
        }
        if (data.contains(mB)) {
            title = title.replace(mB, "");
        }
        if (data.contains(mF)) {
            title = title.replace(mF, "");
        }
        if (data.contains(mG)) {
            title = title.replace(mG, "");
        }
        if (data.contains(mH)) {
            title = title.replace(mH, "");
        }
        if (data.contains(mK)) {
            title = title.replace(mK, "");
        }
        if (data.contains(mN)) {
            title = title.replace(mN, "");
        }
        if (data.contains(mP)) {
            title = title.replace(mP, "");
        }
        if (data.contains(mS)) {
            title = title.replace(mS, "");
        }
        if (data.contains(m6)) {
            title = title.replace(m6, "");
        }
        if (data.contains(m8)) {
            title = title.replace(m8, "");
        }
        if (title.trim().endsWith("/")) {
            title = title.replace("/", "");
        }
        s245.add(title);
        s245.add(author);
        return s245;
    }

    private static ArrayList<String> sp260(String data) {
        ArrayList<String> s260 = new ArrayList<>();
        int i = 0;
        String imprint;
        String year = null;
        for (String s : fi260()) {
            if (data.indexOf(s) > 0) {
                i = data.indexOf(s);
            }
        }
        if (i == 0) {
            imprint = null;
            year = null;
        } else {
            data = data.substring(i + 6);
            data = data.substring(0, data.indexOf(sp) - 7);

            if (data.contains(mC)) {
                year = data.substring(data.indexOf(mC) + 3, data.indexOf(mC) + 7);
            }
            imprint = data.replace(mC + year, "");
            if (data.contains(mA)) {
                imprint = imprint.replace(mA, "");
            }
            if (data.contains(mB)) {
                imprint = imprint.replace(mB, "");
            }
            if (data.contains(mE)) {
                imprint = imprint.replace(mE, "");
            }
            if (data.contains(mF)) {
                imprint = imprint.replace(mF, "");
            }
            if (data.contains(mG)) {
                imprint = imprint.replace(mG, "");
            }
            if (data.contains(m3)) {
                imprint = imprint.replace(m3, "");
            }
            if (data.contains(m6)) {
                imprint = imprint.replace(m6, "");
            }
            if (data.contains(m8)) {
                imprint = imprint.replace(m8, "");
            }
        }
        s260.add(imprint);
        s260.add(year);
        return s260;
    }

    private static String sp852(String data) {
        int i = 0;
        String location;
        for (String f : fi852()) {
            if (data.indexOf(f) > 0) {
                i = data.indexOf(f);
            }
        }
        if (i == 0) {
            location = null;
        } else {
            data = data.substring(i + 6);
            data = data.substring(0, data.indexOf(sp) - 7);

            if (data.contains(mB)) {
                location = data.substring(data.indexOf(mB));
                if (location.contains(mB)) {
                    location = location.replace(mB, "");
                }
                if (location.contains(mC)) {
                    i = location.indexOf(mC);
                    location = location.substring(0, i);
                }
                if (location.contains(mD)) {
                    i = location.indexOf(mD);
                    location = location.substring(0, i);
                }
                if (location.contains(mE)) {
                    i = location.indexOf(mE);
                    location = location.substring(0, i);
                }
                if (location.contains(mF)) {
                    i = location.indexOf(mF);
                    location = location.substring(0, i);
                }
                if (location.contains(mG)) {
                    i = location.indexOf(mG);
                    location = location.substring(0, i);
                }
                if (location.contains(mH)) {
                    i = location.indexOf(mH);
                    location = location.substring(0, i);
                }
                if (location.contains(mI)) {
                    i = location.indexOf(mI);
                    location = location.substring(0, i);
                }
                if (location.contains(mJ)) {
                    i = location.indexOf(mJ);
                    location = location.substring(0, i);
                }
                if (location.contains(mK)) {
                    i = location.indexOf(mK);
                    location = location.substring(0, i);
                }
                if (location.contains(mL)) {
                    i = location.indexOf(mL);
                    location = location.substring(0, i);
                }
                if (location.contains(mM)) {
                    i = location.indexOf(mM);
                    location = location.substring(0, i);
                }
                if (location.contains(mN)) {
                    i = location.indexOf(mN);
                    location = location.substring(0, i);
                }
                if (location.contains(mP)) {
                    i = location.indexOf(mP);
                    location = location.substring(0, i);
                }
                if (location.contains(mS)) {
                    i = location.indexOf(mS);
                    location = location.substring(0, i);
                }
                if (location.contains(mQ)) {
                    i = location.indexOf(mQ);
                    location = location.substring(0, i);
                }
                if (location.contains(mT)) {
                    i = location.indexOf(mT);
                    location = location.substring(0, i);
                }
                if (location.contains(mU)) {
                    i = location.indexOf(mU);
                    location = location.substring(0, i);
                }
                if (location.contains(mX)) {
                    i = location.indexOf(mX);
                    location = location.substring(0, i);
                }
                if (location.contains(mZ)) {
                    i = location.indexOf(mZ);
                    location = location.substring(0, i);
                }
                if (location.contains(m2)) {
                    i = location.indexOf(m2);
                    location = location.substring(0, i);
                }
                if (location.contains(m4)) {
                    i = location.indexOf(m4);
                    location = location.substring(0, i);
                }
                if (location.contains(m6)) {
                    i = location.indexOf(m6);
                    location = location.substring(0, i);
                }
                if (location.contains(m8)) {
                    i = location.indexOf(m8);
                    location = location.substring(0, i);
                }
            } else {
                location = null;
            }
        }
        return location;
    }

    private static String sp916(String data) {
        String type = null;
        int i = 0;
        for (String s : fi916()) {
            if (data.contains(s)) {
                i = data.indexOf(s);
                break;
            }
        }
        if (i <= 0) {
            type = null;
        } else {
            data = data.substring(i + 6);
            type = data.substring(0, data.indexOf(sp) - 7);
            if (type.contains(mA)) {
                type = type.replace(mA, "");
            }
        }
        if (type != null) {
            if (type.contains(m0)) {
                String str = type;
                type = str.substring(0, type.indexOf(m0) - 10);
                type = type + str.replace(m0, " - ").substring(str.indexOf(m0));
            }
        } else {
            type = null;
        }

        return type;
    }

    private static String sp927(String data) {
        String linhvuc;
        if (data.contains(fi927)) {
            data = data.substring(data.indexOf(fi927) + 6);
            linhvuc = data.substring(0, data.indexOf(sp) - 7);
            if (linhvuc.contains("$$")) {
                linhvuc = linhvuc.replaceAll("$/$_", "");
            }
        } else {
            linhvuc = null;
        }
        return linhvuc;
    }

    public static MarcBean marcBeans(String id, String data) {
        if (data.contains("DEL")) {
            return new MarcBean(id, "", "", "", "", "", "", "", "", "", "", "", "");
        } else {
            ArrayList<String> s082 = sp082(data);
            ArrayList<String> s245 = sp245(data);
            ArrayList<String> s260 = sp260(data);
            ArrayList<String> s005 = sp005(data);
            String s852 = sp852(data);
            String s916 = sp916(data);
            String s927 = sp927(data);
            return new MarcBean(id, s005.get(0), s005.get(1), s005.get(2), s082.get(0), s082.get(1), s245.get(0), s245.get(1), s260.get(0), s260.get(1), s852, s916, s927);
        }
    }
}