package com.gokhanozg.hackerrank.abbreviation;

/**
 * Created by Gokhan Ozgozen on 21-Jul-18.
 */
public class TestSol {

    public static void main(String[] args) {
        System.out.println("NO," + Solution.abbreviation("NoK", "K"));
//        System.out.println("YES," + Solution.abbreviation("dvAbCc", "ABC"));
//        System.out.println("YES," + Solution.abbreviation("daBcd", "ABC"));
//        System.out.println("YES," + Solution.abbreviation("AbcDE", "ABDE"));
//        System.out.println("YES," + Solution.abbreviation("okajhbertc", "ABC"));
//        System.out.println("NO," + Solution.abbreviation("Nokajhbertc", "ABC"));
//        System.out.println("YES," + Solution.abbreviation("nokajhbertc", "ABC"));
//        System.out.println("YES," + Solution.abbreviation("noABCdkajhbertc", "ABCDE"));
//        System.out.println("NO," + Solution.abbreviation("noABCkkajhbedrtc", "ABCDE"));
//        System.out.println("NO," + Solution.abbreviation("KXzQ", "K"));
//        System.out.println("YES," + Solution.abbreviation("abcCD", "CD"));
//        System.out.println("YES," + Solution.abbreviation("BFZZVHdQYHQEMNEFFRFJTQmNWHFVXRXlGTFNBqWQmyOWYWSTDSTMJRYHjBNTEWADLgHVgGIRGKFQSeCXNFNaIFAXOiQORUDROaNoJPXWZXIAABZKSZYFTDDTRGZXVZZNWNRHMvSTGEQCYAJSFvbqivjuqvuzafvwwifnrlcxgbjmigkms", "BFZZVHQYHQEMNEFFRFJTQNWHFVXRXGTFNBWQOWYWSTDSTMJRYHBNTEWADLHVGIRGKFQSCXNFNIFAXOQORUDRONJPXWZXIAABZKSZYFTDDTRGZXVZZNWNRHMSTGEQCYAJSF"));
//        System.out.println("LYES," + Solution.abbreviation("hHhAhhcahhacaccacccahhchhcHcahaahhchhhchaachcaCchhchcaccccchhhcaahhhhcaacchccCaahhaahachhacaahhaachhhaaaCalhhchaccaAahHcchcazhachhhaaahaahhaacchAahccacahahhcHhccahaachAchahacaahcahacaahcahacaHhccccaahaahacaachcchhahhacchahhhaahcacacachhahchcaAhhcaahchHhhaacHcacahaccccaaahacCHhChchhhahhchcahaaCccccahhcaachhhacaaahcaaaccccaacaaHachaahcchaahhchhhcahahahhcaachhchacahhahahahAahaAcchahaahcaaaaahhChacahcacachacahcchHcaahchhcahaachnachhhhcachchahhhacHhCcaHhhhcaCccccaaahcahacahchahcaachcchaachahhhhhhhhcahhacacCcchahccaaaaaHhhccaAaaaCchahhccaahhacaccchhcahhcahaahhgacahcahhchcaaAccchahhhaahhccaaHcchaccacahHahChachhcaaacAhacacaacacchhchchacchchcacchachacaahachccchhhaccahcacchaccaahaaaccccccaaaaaaaHhcahcchmcHchcchaaahaccchaaachchHahcaccaaccahcacacahAhaacaacaccaccaaacahhhcacAhaCchcaacCcccachhchchcchhchahchchahchchhchcacaachahhccacachaAhaaachchhchchchhaachahaahahachhaaaccacahhcacchhhaaachaaacAahhcachchachhhcacchacaaChCahhhccahChaachhcahacchanaaacchhhccacacchcahccchAcahacaaachhacchachccaaHacaacAhahcCh", "HAHHCHAACCCAHCHHAHHAHCACCHCCHHCAAHHCACCCAHHHACAAHHHHCHHCAHHAHHAAAHAACAAHAHHCAHAHACHACHCHACACHAAHHAAAHCAHHACACAACHHHCHAHCAHCHHHAHAHACCAAAHCHHCHHCCAACCCCAACHACAACAAHACHCHAHHACCHCAHHHAAACHACAACHCACACAHHCCHAHACCCACCAACHCHHHCCCCCHCCAHHCAAHHAHHHHHHHAACCCCAHCCAAAAAHHHAAAACCAHHCAHACACCHHCHAHAHHCHAACHHHHHCCHCCAHAHCHCAAACCACCCCHACCACHHACHHACACHACCAACCCCAAAAHHAHCHHHCCAHCCHACHHAHCCACACCHAHAAACACCCCAHCCAHACCCCCCHCCHHCHHHHCHCHCAHHHACHAHAACCCAAAACHAACAAAHHAAHAAAHACHHCACHCCHCHAACHACACHHCCCCCAHCACHAAAHCHCAHACAAC"));
//        for (int i = 0; i <1 ; i++) {
//            long start = System.nanoTime();
//            System.out.println("LYES," + Solution.abbreviation("HSIOCQYGXOZBHKTVEXDLTNTLAMPDLOYRZZECYKVLKHYLGRHZBYMLPRIDJVWOMLDUYNUXBIGKRFJSUGZZIXHYNENHVZESEPKOGNCWQXDVEQANBTARFDLFRQPWUKLOATLCBZNENEZYAKBMMFUUKDIWOUGMGJLLBENJCSNCAMGOGIBOGTSPPDDUBNOTZYFNNFYZHGZLQZIJYYYQPOATXZEOOUGDELMPOSNGUFPMISGRIWRTUTZJTFGPUSEEKRIFPKZZYMKBACEMNPAYSIFVTDCWOHGQTEYSPADCMFXRKJRZTBDGJSDCGWQIMBWNPYSCYEIBEQYLVSLGFHBRKPNOKBFNOLGKkimfisbnsmbjnabmrlupqhahcveruwfurfxwiaftdpyuwdjjowtwetimhqvyylpbykfhxlnuyzlzcfgymsmjxbzcfyfwmirpeshsfcwnpgupirxldxrvwqdsanesnkqydhhpfcznisofyltvxikbcudfofjdfgriydlpmkhzipnhkijhbbnglwstpcxxwhjrcctacpwdokcehmfloweknorwgluliqjihitojpdbpnxebdcfswliqgzutstadpslnmxqgzmvvumokpmpkrsdpitdccjtpjtepibzanpgyxndmyktxvknbiwcbgausnbcmygjztfczkfthzaqjigfebrhttrnughxskbpjxkfrqgzzudkoiiqkfzrjzilvdufmgaqfzqmogfsdsgmtzrmcx", "HSIOCQYGXOZBHKTVEXDLTNTLAMPDLOYRZZECYKVLKHYLGRHZBYMLPRIDJVWOMLDUYNUXBIGKRFJSUGZZIXHYNENHVZESEPKOGNCWQXDVEQANBTARFDLFRQPWUKLOATLCBZNENEZYAKBMMFUUKDIWOUGMGJLLBENJCSNCAMGOGIBOGTSPPDDUBNOTZYFNNFYZHGZLQZIJYYYQPOATXZEOOUGDELMPOSNGUFPMISGRIWRTUTZJTFGPUSEEKRIFPKZZYMKBACEMNPAYSIFVTDCWOHGQTEYSPADCMFXRKJRZTBDGJSDCGWQIMBWNPYSCYEIBEQYLVSLGFHBRKPNOKBFNOLGK"));
//            long diff = System.nanoTime() - start;
//            System.out.println(diff);
//            System.out.println("HashCount:" + Solution.hashCount);
//        }
//        long start = System.nanoTime();
//        Objects.hash("HSIOCQYGXOZBHKTVEXDLTNTLAMPDLOYRZZECYKVLKHYLGRHZBYMLPRIDJVWOMLDUYNUXBIGKRFJSUGZZIXHYNENHVZESEPKOGNCWQXDVEQANBTARFDLFRQPWUKLOATLCBZNENEZYAKBMMFUUKDIWOUGMGJLLBENJCSNCAMGOGIBOGTSPPDDUBNOTZYFNNFYZHGZLQZIJYYYQPOATXZEOOUGDELMPOSNGUFPMISGRIWRTUTZJTFGPUSEEKRIFPKZZYMKBACEMNPAYSIFVTDCWOHGQTEYSPADCMFXRKJRZTBDGJSDCGWQIMBWNPYSCYEIBEQYLVSLGFHBRKPNOKBFNOLGKkimfisbnsmbjnabmrlupqhahcveruwfurfxwiaftdpyuwdjjowtwetimhqvyylpbykfhxlnuyzlzcfgymsmjxbzcfyfwmirpeshsfcwnpgupirxldxrvwqdsanesnkqydhhpfcznisofyltvxikbcudfofjdfgriydlpmkhzipnhkijhbbnglwstpcxxwhjrcctacpwdokcehmfloweknorwgluliqjihitojpdbpnxebdcfswliqgzutstadpslnmxqgzmvvumokpmpkrsdpitdccjtpjtepibzanpgyxndmyktxvknbiwcbgausnbcmygjztfczkfthzaqjigfebrhttrnughxskbpjxkfrqgzzudkoiiqkfzrjzilvdufmgaqfzqmogfsdsgmtzrmcx","HSIOCQYGXOZBHKTVEXDLTNTLAMPDLOYRZZECYKVLKHYLGRHZBYMLPRIDJVWOMLDUYNUXBIGKRFJSUGZZIXHYNENHVZESEPKOGNCWQXDVEQANBTARFDLFRQPWUKLOATLCBZNENEZYAKBMMFUUKDIWOUGMGJLLBENJCSNCAMGOGIBOGTSPPDDUBNOTZYFNNFYZHGZLQZIJYYYQPOATXZEOOUGDELMPOSNGUFPMISGRIWRTUTZJTFGPUSEEKRIFPKZZYMKBACEMNPAYSIFVTDCWOHGQTEYSPADCMFXRKJRZTBDGJSDCGWQIMBWNPYSCYEIBEQYLVSLGFHBRKPNOKBFNOLGK");
//        long diff = System.nanoTime() - start;
//        System.out.println(diff);


    }
}
