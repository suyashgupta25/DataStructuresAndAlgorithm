package com.practice.strings;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlTagExtractor {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0 && in.hasNextLine()){
            String line = in.nextLine();
            String[] lines = line.split("\n");
            for (String string : lines) {
                String regex = "<(.+)>([^<>]+)</\\1>";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(string);
                while (matcher.find()) {
                    // String n1 = matcher.group(0);
                    // String n2 = matcher.group(1);
                    String match = matcher.group(2);
                    // System.out.println("Group 0: " + n1);
                    // System.out.println("Group 1: " + n2);
                    System.out.println(match);
                }

                matcher.reset();

                if (matcher.find() == false) {
                    System.out.println("None");
                }
            }
            testCases--;
        }
        in.close();
    }

    public static void main2(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int count = scanner.nextInt();
//        scanner.nextLine();
//        List<String> contents = new ArrayList<>();
//        for (int i = 0; i < count; i++) {
//            String string = scanner.nextLine();
//            contents.addAll(processForTags(string));
//        }

//        List<String> contents = processForTags("<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while<par>");
        List<String> contents = processForTags("wRhDGQCG`r N4=cWqp4jF\"#I7#)jofKUYktmjH(\"s2nD4+NxsN)tpCf2U@78MsGNbEgSgR=6`\"y685~I(D-p&T2BnaJNa%S%y9pYMb_9v{PlScQ7R=~~xnSkpSd<orcsjzalN#eslhhH2d\"1MD)pzc*$tBG-mmI_*zW><xMphtS-F8MVM^u2n5tN2DthGw{KZ`y7)><ZpjQU2&UMjzwJwnV70-CiM}M-OvR%a)Vk3R}2><DqcnlvJJa7ZYYrX^M*BI^*A_-mm0 HT4i^syNtujpEE8M@><mpX{FWXe#$d`)QdqT#eBbH=EJOXc@cFhxpJg14#*G0 o-w9G++`GA9U><PbwFCKiY2D^jhX_l7fM}tsB6QKv#@U#g%P%><WNbHpmOM# X_$FjjX$49DedlEf~_d&3j`LU9OLM%@y)2u^A5aO#><gXzyXZFrpOGaC+M4)kG`d5L*lRW5A#O0i=V023f_iSwqL$_qRMp59PW gf6><GfYTkjn{CTWM-U@3Wv(h( ~Cnc9&BKA>YjncQJp=mN8OV9WEviqvJT`YS$WD=^gryB)NWAal</GfYTkjn{CTWM-U@3Wv(h( ~Cnc9&BKA>QMewBnIzsV</WNbHpmOM# X_$FjjX$49DedlEf~_d&3j`LU9OLM%@y)2u^A5aO#></PbwFCKiY2D^jhX_l7fM}tsB6QKv#@U#g%P%>dPcdFnfTMuYyOFExhXoymEYRVptmHjbgR</ZpjQU2&UMjzwJwnV70-CiM}M-OvR%a)Vk3R}2>wDegwAFAmjapXOejj</xMphtS-F8MVM^u2n5tN2DthGw{KZ`y7)>gEpaCbApodfJVPXVuct<bbgnEsMI_M%9L=E v)f6GjS_kSK6W5HWdel)VbBvZRG)#&b=+6k(O9=&C>rulVew89#uyWF}4`T\"xULOZ%1\"5Cu)&x7qD0</bbgnEsMI_M%9L=E v)f6GjS_kSK6W5HWdel)VbBvZRG)#&b=+6k(O9=&C><RicmJtmTo9uWkW^szFhT_OJ}_Jr4Galzm^v24RxPJkiUQN`vXV><ofMiPADbv&XoS=rU{r5JRfE+R}DgSHV@%zDk1golMD_IMuJ1U`~~TyD><lCERjrGdOfuVC0\"8W##`L8x+qC=HW><UnWhEk9TPbbij$y_M0J {0FKn*Gk`IHq88Z3I*18iOvbdA_><pXHzGgQgKWj}@x^Mr}7X_Sf6_P*b_{`A$$AouU&e81l}uy3ijn&K1BmXHY>nhPeJWSTIkb Gs_~ztKS*b#36E+ThD</pXHzGgQgKWj}@x^Mr}7X_Sf6_P*b_{`A$$AouU&e81l}uy3ijn&K1BmXHY></UnWhEk9TPbbij$y_M0J {0FKn*Gk`IHq88Z3I*18iOvbdA_>zBesDtLSpVYfUzgds</lCERjrGdOfuVC0\"8W##`L8x+qC=HW>OjuAcMjbwMLuylplc</RicmJtmTo9uWkW^szFhT_OJ}_Jr4Galzm^v24RxPJkiUQN`vXV>ZuWHgfxmI&l}D@r%q=mSj  Y&paOAZFf=~}I_Eg<CJQuDskoQL=5PG-ONFzA\"yYhcEB2#ize-4H%+^b=Db~p(1U%=UKeCt5ZWS>RCKchSzpkdh0oF aNt (%Vu ^ap3K0GP634h_k%1FsO$Wu0n1aeLEPSBHpGpHdWrIrIApQrorxMIBVbyhh</CJQuDskoQL=5PG-ONFzA\"yYhcEB2#ize-4H%+^b=Db~p(1U%=UKeCt5ZWS><XqPMRbmTQnlc#1 =N^z7~QuF2v(4}fd6^2BVJ8Wog4EHA~l%RNg_7Zb><RIEb0nii0bO5WV$%n#}TgB*fLl>RIAFwuGoRsU_9PleTRq{FS}fa3)1kRgn(C}ohOYXDqk</RIEb0nii0bO5WV$%n#}TgB*fLl>fQtRVddxdcuYJAikIUG</XqPMRbmTQnlc#1 =N^z7~QuF2v(4}fd6^2BVJ8Wog4EHA~l%RNg_7Zb>WmwMTg1FWlk0G6(mmh-SN\"k&hoKwzfF0PLel$2)aLS5tW22jz=zX9M7S88Hm_1aF7<rQNSVnYKC-ALi0RYY#sqP%J9CRykB_p14ifh@@#j0Svdm57N}{6_#QRpFytrvzk&E{$1>tULUXNsa`iS~T(_BQ`EqJNSgxcO)$`~d=`F2Dqbst4-_N</rQNSVnYKC-ALi0RYY#sqP%J9CRykB_p14ifh@@#j0Svdm57N}{6_#QRpFytrvzk&E{$1><MB=7g =8{_aUlwE_>MoUMPsYfBJNd$G~\"=dbO0U%aiOUaBBG&%(oFSfOZYvXSPFfwh@R QqyvTQ)3rJu%k6OBuBXkSShV=nm\"qJ46_VKi1- oHK^EdKTk~gs%t\"8<XnRH-gxlai2Jh`jmje=IUBZh`SUC\"et(=81U0_wyx_mnRD4>LfOJpqbcGhsTzasaaYU</XnRH-gxlai2Jh`jmje=IUBZh`SUC\"et(=81U0_wyx_mnRD4>YYYbEkrZ^wz=4046`&}N (^*_8EO^Eraw*jTFD~+IX%YX_Oo`f3BlFjmhSrEtE8FTe5870&+z(i@czXtI2mRfw7p^yFO_~r{*D0su6w&vnXb0aC+52Kol<byi)o%`Y{NBe>zYcZaQOKUCW4G0mJ$xe*xGIuY-&@1S`wkck%203&P{N}<lHrYNvRe#sQdvy-TurFDw+lUOyM1UI2sv`=><Nrp\"OjKiUXOhM(fRCqS\"C1-SmCTx%urq^=NEF-i*q&x><XKKZIu2zuIXam%aUp`bmJ(JwI`A");
        for (int i = 0; i < contents.size(); i++) {
            System.out.println(contents.get(i));
        }
    }

    private static List<String> processForTags(String line) {
//        System.out.println("Length: "+line.length());
        List<String> openTags = new ArrayList<>();
        int i = 0;
        List<String> contents = new ArrayList<>();
        StringBuilder content = new StringBuilder();
        while (i < line.length()) {
            char charAt = line.charAt(i);
            if (charAt == '<') {
                int i2 = line.indexOf('>', i);
                if (i2 != -1 && line.charAt(i + 1) == '/') {
                    //closing tag
                    String closingTag = line.substring(i+2, i2);
                    if(!openTags.isEmpty() && closingTag.equals(openTags.get(openTags.size()-1))) {
                        openTags.remove(openTags.get(openTags.size() -1 ));
                        if(!content.isEmpty()) {
                            contents.add(content.toString());
                        }
                    }
                    i = i2;
                    content = new StringBuilder();
                } else {
                    // open tag
                    if(i2 != -1) {
                        String tag = line.substring(i+1, i2);
                        if(!tag.isEmpty()) {
                            openTags.add(tag);
                        }
                        i = i2;
                        content = new StringBuilder();
                    }
                }
            }
            if(i >= line.length()) {
                break;
            }
            char contentAtChar = line.charAt(i);
            if (contentAtChar != '<' && contentAtChar != '>') {
                content.append(contentAtChar);
            }
            i++;
        }
        if(contents.isEmpty()) {
            contents.add("None");
        }
        return contents;
    }
}
