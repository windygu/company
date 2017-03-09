package com.astrolink.util.tools.business;

import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.astrolink.util.tools.Base64;


public class DmTools {
	
	public String encodeSMS(String sms) {
		String key = "aZ8RyZRWxcJno2cBcwQDAHYjmZoOC5Gi";
		StringBuilder stringBuilderKey = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			stringBuilderKey.append(key);
		}
		String tempKeyStr = stringBuilderKey.toString();
		byte[] keyTable = new byte[1024];
		for (int i = 0; i < 1024; i = i + 4) {
			keyTable[i] = (byte) (i / 4);
		}
		int byte_1, byte_2, result, keep = 0, temp;
		for (int i = 0; i < 256; i++) {
			byte_1 = tempKeyStr.charAt(i);
			byte_2 = keyTable[i * 4];
			result = (byte_1 + keep + byte_2) & 0xff;
			keep = result;
			keyTable[4 * i] = keyTable[4 * result];
			keyTable[4 * result] = (byte) byte_2;
		}
		int m = 0;
		byte[] output = new byte[125];
		for (int i = 0; i < 125; i++) {
			int n = (i + 1) * 4;
			byte_1 = keyTable[n];
			m = (m + byte_1) & 0xff;
			keyTable[n] = keyTable[m * 4];
			keyTable[m * 4] = (byte) byte_1;
			temp = (((byte_1 & 0xff) + keyTable[n]) & 0xff) * 4;

			int byteN = (sms.charAt(i) ^ keyTable[temp]) & 0xff;
			if (((byteN - 32) & 0xFF) > 0x5E || ((byteN - 96) & 0xFF) <= 0) {
				output[i] = (byte) (sms.charAt(i));
			} else {
				output[i] = (byte) (byteN);
			}
		}
		return new String(output);

	}

	public  String decode_RequestResponse(String key, String str) {
		byte[] input = null;
		input = Base64.decode(str.trim());
		byte[] result = decodeRequestResponse(key, input, input.length);

		return new String(result);
	}

	public  byte[] decodeRequestResponse(String initTableString, byte[] inputData, int inputDatalength) {
		byte[] result = new byte[inputDatalength];
		byte[] keytable = initTableString.getBytes();
		byte[] tableData = new byte[0x100];
		for (int i = 0; i < 0x100; i++) {
			tableData[i] = (byte) (i & 0xFF);
		}
		byte input_value, table_value, change_value;
		int temp = 0;
		for (int i = 0; i < 0x100; i++) {
			temp = (temp + tableData[i]) & 0xFF;
			table_value = tableData[i];
			input_value = (byte) keytable[(i % keytable.length)];
			temp = (input_value + temp) & 0xFF;
			tableData[i] = tableData[temp];
			;
			tableData[temp] = table_value;
			tableData[i] = (byte) (((int) (tableData[i] & 0xFF) + 0x69) % 0xFF);
		}
		temp = 0;
		int var_238 = 0, var_234 = 0;
		for (int i = 0; i < inputDatalength; i++) {
			var_238 = (var_238 + 1) & 0xFF;
			table_value = tableData[var_238];
			var_234 = (var_234 + table_value) & 0xFF;
			change_value = tableData[var_234];
			tableData[var_238] = change_value;
			tableData[var_234] = table_value;
			temp = (change_value + table_value) & 0xFF;
			result[i] = (byte) (tableData[temp] ^ inputData[i]);
		}
		return result;
	}

	public String encode_RequestResponse(String key, String str) {
		byte[] result = decodeRequestResponse(key, str.getBytes(), str.length());

		return Base64.encode(result).replaceAll("\r\n", "");
	}

	public String generateEncodeCID(String cid) {
		int v1, v2, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20, v21, v22, v23, v24, v25, v26, v27, v28, v29, v30, v31, v32, v33, v34, v35, v36, v37, v38, v39, v40, v41, v42, v43, v44, v45, v46, v47, v48, v49, v50, v51, v52, v53, v54, v55, v56, v57, v58, v59, v60, v61, v62, v63, v64, v65, v66, v67, v68, v69, v70, v71, v72, v73, v74, v75, v76, v77, v78, v79, v80, v81, v82, v83, v84, v85, v86, v87, v88, v89, v90, v91, v92, v93, v94, v95, v96, v97, v98, v99, v100, v101, v102, v103, v104, v105, v106, v107, v108, v109, v110, v111, v112, v113, v114, v115, v116, v117, v118, v119, v120, v121, v122, v123, v124, v125, v126, v127, v128, v129, v130, v131, v132, v133, v134, v135, v136, v137, v138, v139, v140, v141, v142, v143, v144, v145, v146, v147, v148, v149;

		v1 = 0x10325476;
		v2 = 0x98BADCFE;
		v4 = 0xEFCDAB89;
		v5 = 0x67452301;
		v6 = 0x31303534;
		int[] intArray = getIntArrayFromString(cid);

		int t = (v5 + intArray[0] - 680876936 + ((v2 ^ v1) & v4 ^ v1));
		v7 = ROR4(t, 25);
		v8 = v7 + v4;
		v9 = intArray[1];
		t = v1 + v9 - 389564586 + ((v2 ^ v4) & v8 ^ v2);
		v10 = ROR4(t, 20);
		v11 = v10 + v8;
		v12 = intArray[2];
		v13 = ROR4(((v8 ^ v4) & v11 ^ v4) + v12 + v2 + 606105819, 15);
		v14 = v13 + v11;
		v15 = intArray[3];
		v16 = ROR4(((v11 ^ v8) & (v13 + v11) ^ v8) + v4 + v15 - 1044525330, 10);
		v17 = intArray[4];
		v18 = v16 + v13 + v11;
		v19 = ROR4((((v13 + v11) ^ v11) & v18 ^ v11) + v17 - 176418897 + v8, 25);
		v20 = intArray[5];
		v21 = v19 + v18;
		v22 = ROR4(((v18 ^ v14) & v21 ^ v14) + v20 + 1200080426 + v11, 20);
		v23 = intArray[6];
		v24 = v22 + v21;
		v25 = ROR4(((v21 ^ v18) & v24 ^ v18) + v23 - 1473231341 + v14, 15);
		v26 = intArray[7];
		v27 = v25 + v24;
		v28 = ROR4(((v24 ^ v21) & v27 ^ v21) + v26 - 45705983 + v18, 10);

		v29 = 0x0000800A;
		v30 = v28 + v27;
		v31 = ROR4(((v27 ^ v24) & v30 ^ v24) + v29 + 1770035416 + v21, 25);

		v32 = 0x00000000;
		v33 = v31 + v30;
		v34 = ROR4(((v30 ^ v27) & v33 ^ v27) + v32 - 1958414417 + v24, 20);

		v35 = 0x00000000;
		v36 = v34 + v33;
		v37 = ROR4(((v33 ^ v30) & v36 ^ v30) + v35 - 42063 + v27, 15);

		v38 = 0x00000000;
		v39 = v37 + v36;
		v40 = ROR4(((v36 ^ v33) & v39 ^ v33) + v38 - 1990404162 + v30, 10);

		v41 = 0x00000000;
		v42 = v40 + v39;
		v43 = ROR4(((v39 ^ v36) & v42 ^ v36) + v41 + 1804603682 + v33, 25);

		v44 = 0x00000000;
		v45 = v43 + v42;
		v46 = ROR4(v36 + v44 - 40341101 + ((v42 ^ v39) & v45 ^ v39), 20);

		v47 = 0x00000108;
		v48 = v46 + v45;

		v49 = 0x00000000;
		v50 = v49;

		v51 = ROR4(v39 + v47 - 1502002290 + ((v45 ^ v42) & v48 ^ v42), 15);
		v52 = v51 + v48;
		v53 = ROR4(v49 + 1236535329 + v42 + ((v48 ^ v45) & v52 ^ v45), 10);
		v54 = v53 + v52;
		v55 = ROR4(v9 - 165796510 + v45 + ((v54 ^ v52) & v48 ^ v52), 27);
		v56 = v55 + v54;
		v57 = ROR4(v23 - 1069501632 + v48 + ((v56 ^ v54) & v52 ^ v54), 23);
		v58 = v57 + v56;
		v59 = ROR4(v38 + 643717713 + v52 + ((v58 ^ v56) & v54 ^ v56), 18);
		v60 = v59 + v58;

		v61 = ROR4(((v60 ^ v58) & v56 ^ v58) + v6 - 373897302 + v54, 12);
		v62 = v61 + v60;
		v63 = ROR4(((v62 ^ v60) & v58 ^ v60) + v20 - 701558691 + v56, 27);
		v64 = v63 + v62;
		v65 = ROR4(((v64 ^ v62) & v60 ^ v62) + v35 + 38016083 + v58, 23);
		v66 = v65 + v64;
		v67 = ROR4(((v66 ^ v64) & v62 ^ v64) + v50 - 660478335 + v60, 18);
		v68 = v67 + v66;
		v69 = ROR4(((v68 ^ v66) & v64 ^ v66) + v17 - 405537848 + v62, 12);
		v70 = v69 + v68;
		v71 = ROR4(((v70 ^ v68) & v66 ^ v68) + v32 + 568446438 + v64, 27);
		v72 = v71 + v70;
		v73 = ROR4(((v72 ^ v70) & v68 ^ v70) + v47 - 1019803690 + v66, 23);
		v74 = v73 + v72;
		v75 = ROR4(((v74 ^ v72) & v70 ^ v72) + v15 - 187363961 + v68, 18);
		v76 = v75 + v74;
		v77 = ROR4(((v76 ^ v74) & v72 ^ v74) + v29 + 1163531501 + v70, 12);
		v78 = v77 + v76;
		v79 = ROR4(((v78 ^ v76) & v74 ^ v76) + v44 - 1444681467 + v72, 27);
		v80 = v79 + v78;
		v81 = ROR4(v74 + v12 - 51403784 + (((v79 + v78) ^ v78) & v76 ^ v78), 23);
		v82 = v81 + v79 + v78;
		v83 = ROR4(v76 + v26 + 1735328473
				+ ((v82 ^ (v79 + v78)) & v78 ^ (v79 + v78)), 18);
		v84 = v83 + v82;
		v85 = ROR4(v78 + v41 - 1926607734 + ((v79 + v78) & (v84 ^ v82) ^ v82),
				12);
		v86 = v85 + v84;
		v87 = ROR4(v80 + v20 - 378558 + (v84 ^ v82 ^ v86), 28);
		v88 = v87 + v86;
		v89 = ROR4(v29 - 2022574463 + v82 + (v86 ^ v84 ^ v88), 21);
		v90 = v89 + v88;
		v91 = ROR4(v38 + 1839030562 + v84 + (v88 ^ v86 ^ v90), 16);
		v92 = v91 + v90;
		v93 = ROR4((v90 ^ v88 ^ v92) + v47 - 35309556 + v86, 9);
		v94 = v93 + v92;
		v95 = ROR4((v92 ^ v90 ^ v94) + v9 - 1530992060 + v88, 28);
		v96 = v95 + v94;
		v97 = ROR4((v94 ^ v92 ^ v96) + v17 + 1272893353 + v90, 21);
		v98 = v97 + v96;
		v99 = ROR4((v96 ^ v94 ^ v98) + v26 - 155497632 + v92, 16);
		v100 = v99 + v98;
		v101 = ROR4((v98 ^ v96 ^ v100) + v35 - 1094730640 + v94, 9);
		v102 = v101 + v100;
		v103 = ROR4((v100 ^ v98 ^ v102) + v44 + 681279174 + v96, 28);
		v104 = v103 + v102;
		v105 = ROR4((v102 ^ v100 ^ v104) + v6 - 358537222 + v98, 21);
		v106 = v105 + v104;
		v107 = ROR4((v104 ^ v102 ^ v106) + v15 - 722521979 + v100, 16);
		v108 = v107 + v106;
		v109 = ROR4((v106 ^ v104 ^ v108) + v23 + 76029189 + v102, 9);
		v110 = v109 + v108;
		v111 = ROR4((v108 ^ v106 ^ v110) + v32 - 640364487 + v104, 28);
		v112 = v111 + v110;
		v113 = ROR4(v106 + v41 - 421815835 + (v110 ^ v108 ^ v112), 21);
		v114 = v113 + v112;
		v115 = ROR4(v108 + v50 + 530742520 + (v112 ^ v110 ^ v114), 16);
		v116 = v115 + v114;
		v117 = ROR4(v12 - 995338651 + v110 + (v114 ^ v112 ^ v116), 9);
		v118 = v117 + v116;
		v119 = ROR4(v6 - 198630844 + v112 + ((~v114 | v118) ^ v116), 26);
		v120 = v119 + v118;
		v121 = ROR4(v26 + 1126891415 + v114 + ((~v116 | v120) ^ v118), 22);
		v122 = v121 + v120;
		v123 = ROR4(v47 - 1416354905 + v116 + ((~v118 | v122) ^ v120), 17);
		v124 = v123 + v122;
		v125 = ROR4(v118 + v20 - 57434055 + ((~v120 | v124) ^ v122), 11);
		v126 = v125 + v124;
		v127 = ROR4(v41 + 1700485571 + v120 + ((~v122 | v126) ^ v124), 26);
		v128 = v127 + v126;
		v129 = ROR4(v15 - 1894986606 + v122 + ((~v124 | v128) ^ v126), 22);
		v130 = v129 + v128;
		v131 = ROR4(v35 - 1051523 + v124 + ((~v126 | v130) ^ v128), 17);
		v132 = v131 + v130;
		v133 = ROR4(v9 - 2054922799 + v126 + ((~v128 | v132) ^ v130), 11);
		v134 = v133 + v132;
		v135 = ROR4(v29 + 1873313359 + v128 + ((~v130 | v134) ^ v132), 26);
		v136 = v135 + v134;
		v137 = ROR4(v50 - 30611744 + v130 + ((~v132 | v136) ^ v134), 22);
		v138 = v137 + v136;
		v139 = ROR4(v23 - 1560198380 + v132 + ((~v134 | v138) ^ v136), 17);
		v140 = v139 + v138;
		v141 = ROR4(v44 + 1309151649 + v134 + ((~v136 | v140) ^ v138), 11);
		v142 = v141 + v140;
		v143 = ROR4(v17 - 145523070 + v136 + ((~v138 | v142) ^ v140), 26);
		v144 = v143 + v142;
		v145 = ROR4(v38 - 1120210379 + v138 + ((~v140 | v144) ^ v142), 22);
		v146 = v145 + v144;
		v147 = ROR4(v12 + 718787259 + v140 + ((~v142 | v146) ^ v144), 17);
		v148 = v147 + v146;

		v5 = v144 + v5;
		v149 = ROR4(v32 - 343485551 + v142 + ((~v144 | v148) ^ v146), 11);
		v4 += v148 + v149;
		v2 += v148;
		v1 += v146;

		byte[] result = byteMerger(int2bytes(v5), int2bytes(v4));
		result = byteMerger(result, int2bytes(v2));
		result = byteMerger(result, int2bytes(v1));
		return new String(Base64.encode(result));
	}

	public  String generateSingnature(String str,byte [] Key1,byte [] Key2) {
		byte[] k1 = new byte[Key1.length];
		byte[] k2 = new byte[Key2.length];
		System.arraycopy(Key1, 0, k1, 0, Key1.length);
		;
		System.arraycopy(Key2, 0, k2, 0, Key2.length);
		;

		getSingnature1(str.getBytes(), str.length(), k1);
		byte[] r1 = getSingnature2(k1);

		getSingnature1(r1, 20, k2);
		byte[] r2 = getSingnature2(k2);

		String result = Base64.encode(r2).replaceAll("\r\n", "");
		return result;
	}

	public  void getSingnature1(byte[] data, int datalen, byte[] key) {
		byte[] v3;
		int v4;
		int v5;
		int v6;
		int v7;
		boolean v8;
		int v9;
		int v10;
		int v11;
		byte[] v12;
		int v13;
		byte[] v14;
		int v15;
		byte v16;
		byte[] v17;
		byte[] v18;
		byte[] v19;
		byte[] v20;
		byte[] v21;
		int v22;
		int v23;
		byte v24;
		byte[] v25;

		v3 = key;
		v4 = bytes2Int(key, 20);
		v5 = datalen;
		v6 = 8 * datalen;
		v7 = v6 + v4;
		v8 = v6 + v4 >= v6;
		int2bytes(v3, v6 + v4, 20);
		if (v6 + v4 < v6)
			v7 = bytes2Int(key, 24);
		v9 = v4 >> 3;
		if (!v8) {
			int2bytes(v3, v7 + 1, 24);
		}
		v10 = v9 & 0x3F;
		v11 = 64 - v10;
		int t = bytes2Int(key, 24) + (v5 >> 29);
		int2bytes(v3, t, 24);
		v12 = data;
		if (v5 >= 64 - v10) {
			v14 = v3;
			v15 = 0;
			while (true) {
				v17 = v14;
				if (v15 >= v11)
					break;
				v16 = v12[v15];
				v17[28 + v15 + v10] = v16;
				v15++;
			}
			v13 = v11;
			getSingnature3(v3, 28, v3);
			v18 = v12;
			int i = 0;
			while (true) {
				v19 = v18;
				if (v13 >= (v5 - 63))
					break;
				getSingnature3(v3, v11 + i, v19);
				v13 += 64;
				i += 64;

			}
			v10 = 0;
		} else {
			v13 = 0;
		}
		v20 = v12;
		v21 = v3;
		v22 = v5 - v13;
		v23 = 0;
		while (true) {
			v25 = v21;
			if (v23 >= v22)
				break;
			v24 = v20[v13 + v23];
			v25[v23 + 28 + v10] = v24;
			v23++;
		}
		return;

	}

	public  byte[] getSingnature3(byte[] result, int a2, byte[] a3) {
		byte[] v2;
		int v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20, v21, v22, v23, v24, v25, v26, v27, v28, v29, v30, v31, v32, v33, v34, v35, v36, v37, v38, v39, v40, v41, v42, v43, v44, v45, v46, v47, v48, v49, v50, v51, v52, v53, v54, v55, v56, v57, v58, v59, v60, v61, v62, v63, v64, v65, v66, v67, v68, v69, v70, v71, v72, v73, v74, v75, v76, v77, v78, v79, v80, v81, v82, v83, v84, v85, v86, v87, v88, v89, v90, v91, v92, v93, v94, v95, v96, v97, v98, v99, v100, v101, v102, v103, v104, v105, v106, v107, v108, v109, v110, v111, v112, v113, v114, v115, v116, v117, v118, v119, v120, v121, v122, v123, v124, v125, v126, v127, v128, v129, v130, v131, v132, v133, v134, v135, v136, v137, v138, v139, v140, v141, v142, v143, v144, v145, v146, v147, v148, v149, v150, v151, v152, v153, v154, v155, v156, v157, v158, v159, v160, v161, v162, v163, v164, v165, v166, v167, v168, v169, v170, v171, v172, v173, v174, v175, v176, v177, v178, v179, v180, v181, v182, v183, v184, v185, v186, v187, v188, v189, v190, v191, v192, v193, v194, v195, v196, v197, v198, v199, v200, v201, v202, v203, v204, v205, v206, v207, v208, v209, v210, v211, v212, v213, v214, v215, v216, v217, v218, v219, v220, v221, v222, v223, v224, v225, v226, v227, v228, v229, v230, v231, v232, v233, v234, v235, v236, v237, v238, v239, v240, v241, v242, v243, v244, v245, v246, v247, v248, v249, v250, v251, v252, v253, v254, v255, v256, v257, v258, v259, v260, v261, v262, v263, v264, v265, v266, v267, v268, v269, v270, v271, v272, v273, v274, v275, v276, v277, v278, v279, v280, v281, v282, v283, v284, v285, v286, v287, v288, v289, v290, v291, v292, v293, v294, v295, v296, v297, v298, v299, v300, v301, v302, v303, v304, v305, v306, v307, v308, v309, v310, v311, v312, v313, v314, v315, v316, v317, v318, v319, v320, v321, v322, v323, v324, v325, v326, v327, v328, v329, v330, v331, v332, v333, v334, v335, v336, v337, v338, v339, v340, v341, v342, v343, v344, v345, v346, v347, v348, v349, v350, v351, v352, v353, v354, v355, v356, v357, v358, v359, v360, v361, v362, v363, v364, v365, v366, v367, v368, v369, v370, v371, v372, v373, v374, v375, v376, v377, v378, v379, v380, v381, v382, v383, v384, v385, v386, v387, v388, v389, v390, v391, v392, v393, v394, v395, v396, v397, v398, v399, v400, v401, v402, v403, v404, v405, v406, v407, v408, v409, v410, v411, v412, v413, v414, v415, v416, v417, v418, v419, v420, v421, v422, v423, v424, v425, v426, v427, v428, v429, v430, v431, v432, v433, v434, v435, v436, v437, v438, v439, v440, v441, v442, v443, v444, v445, v446, v447, v448, v449, v450, v451, v452, v453, v454, v455, v456, v457, v458, v459, v460, v461, v462, v463, v464, v465, v466, v467, v468, v469, v470, v471, v472, v473, v474, v475, v476, v477, v478, v479, v480, v481, v482, v483, v484, v485, v486, v487, v488, v489, v490, v491, v492, v493, v494, v495, v496, v497, v498, v499, v500, v501, v502, v503, v504, v505, v506, v507, v508, v509, v510, v511, v512, v513, v514, v515, v516, v517, v518, v519, v520, v521, v522, v523, v524, v525, v526, v527, v528, v529, v530, v531, v532, v533, v534, v535, v536, v537, v538, v539, v540, v541, v542, v543, v544, v545, v546, v547, v548, v549, v550, v551, v552, v553, v554, v555, v556, v557, v558, v559, v560, v561, v562, v563, v564, v565, v566, v567, v568, v569, v570, v571, v572, v573, v574, v575, v576, v577, v578, v579, v580, v581, v582, v583, v584, v585, v587, v588, v589, v590, v591, v593, v594, v595, v596, v597, v598, v599, v600, v601, v602, v603, v604, v605, v606, v607;
		byte v592[];

		v2 = a3;
		v3 = 0;
		v592 = new byte[64];
		int i = 0;
		do {
			v4 = (a3[v3 + a2] & 0x000000FF) << 24;
			int2bytes(v592, v4, v3);
			v5 = v4 | ((v2[1 + i + a2] & 0x000000FF) << 16);
			int2bytes(v592, v5, v3);
			v6 = v5 | ((v2[2 + i + a2] & 0x000000FF) << 8);
			int2bytes(v592, v6, v3);
			v7 = (v2[3 + i + a2] & 0x000000FF);
			i += 4;
			int2bytes(v592, v6 | v7, v3);
			v3 += 4;
		} while (v3 != 64);
		v593 = bytes2Int(v592, 4);
		v594 = bytes2Int(v592, 8);
		v595 = bytes2Int(v592, 12);
		v596 = bytes2Int(v592, 16);
		v597 = bytes2Int(v592, 20);
		v598 = bytes2Int(v592, 24);
		v599 = bytes2Int(v592, 28);
		v600 = bytes2Int(v592, 32);
		v601 = bytes2Int(v592, 36);
		v602 = bytes2Int(v592, 40);
		v603 = bytes2Int(v592, 44);
		v604 = bytes2Int(v592, 48);
		v605 = bytes2Int(v592, 52);
		v606 = bytes2Int(v592, 56);
		v607 = bytes2Int(v592, 60);
		v8 = bytes2Int(result, 8);
		v9 = bytes2Int(result, 12);
		v10 = bytes2Int(result, 4);
		v12 = ROR4(v10, 2);
		v11 = v12;
		v13 = v12 ^ v8;
		int temp_result = bytes2Int(result, 0);
		v15 = ROR4(temp_result, 2);
		v14 = v15;
		v16 = ROR4(temp_result, 27);
		v17 = bytes2Int(v592, 0) + 1518500249 + bytes2Int(result, 16) + v16 + ((v9 ^ v8) & v10 ^ v9);
		v19 = ROR4(v17, 27);
		v18 = v593 + 1518500249 + v9 + (v13 & bytes2Int(result, 0) ^ v8) + v19;
		v21 = ROR4(v17, 2);
		v20 = v21;
		v22 = v17 & (v11 ^ v14) ^ v11;
		v23 = v21 ^ v14;
		v24 = v594 + 1518500249 + v8 + v22;
		v26 = ROR4(v18, 2);
		v25 = v26;
		v28 = ROR4(v18, 27);
		v27 = v24 + v28;
		v29 = v595 + 1518500249 + v11 + (v23 & v18 ^ v14);
		v31 = ROR4(v27, 2);
		v30 = v31;
		v33 = ROR4(v27, 27);
		v32 = v29 + v33;

		v34 = v596 + 1518500249 + v14 + ((v25 ^ v20) & v27 ^ v20);
		v36 = ROR4(v32, 2);
		v35 = v36;
		v38 = ROR4(v32, 27);
		v37 = v34 + v38;
		v40 = ROR4(v37, 27);

		v39 = v597 + 1518500249 + v20 + ((v30 ^ v25) & v32 ^ v25) + v40;
		v42 = ROR4(v37, 2);
		v41 = v42;
		v43 = (v35 ^ v30) & v37 ^ v30;
		v44 = v42 ^ v35;
		v45 = v598 + 1518500249 + v25 + v43;
		v47 = ROR4(v39, 2);
		v46 = v47;
		v49 = ROR4(v39, 27);
		v48 = v45 + v49;
		v50 = (v46 ^ v41) & v48 ^ v41;
		v52 = ROR4(v48, 27);
		v51 = v599 + 1518500249 + v30 + (v44 & v39 ^ v35) + v52;
		v54 = ROR4(v48, 2);
		v53 = v54;
		v55 = v54 ^ v46;
		v56 = v600 + 1518500249 + v35 + v50;
		v58 = ROR4(v51, 2);
		v57 = v58;

		v60 = ROR4(v51, 27);
		v59 = v56 + v60;
		v61 = v601 + 1518500249 + v41 + (v55 & v51 ^ v46);
		v63 = ROR4(v59, 2);
		v62 = v63;
		v65 = ROR4(v59, 27);
		v64 = v61 + v65;
		v66 = v602 + 1518500249 + v46 + ((v57 ^ v53) & v59 ^ v53);
		v68 = ROR4(v64, 2);
		v67 = v68;
		v70 = ROR4(v64, 27);
		v69 = v66 + v70;
		v72 = ROR4(v69, 27);
		v71 = v603 + 1518500249 + v53 + ((v62 ^ v57) & v64 ^ v57) + v72;
		v74 = ROR4(v69, 2);
		v73 = v74;
		v75 = v74 ^ v67;
		v76 = v604 + 1518500249 + v57 + ((v67 ^ v62) & v69 ^ v62);
		v78 = ROR4(v71, 2);
		v77 = v78;
		v80 = ROR4(v71, 27);
		v79 = v76 + v80;
		v82 = ROR4(v79, 27);
		v81 = v605 + 1518500249 + v62 + (v75 & v71 ^ v67) + v82;
		v84 = ROR4(v79, 2);
		v83 = v84;
		v85 = v606 + 1518500249 + v67 + ((v77 ^ v73) & v79 ^ v73);
		v86 = (v84 ^ v77) & v81;
		v87 = ROR4(v594 ^ bytes2Int(v592, 0) ^ v600 ^ v605, 31);
		v88 = v87;
		v90 = ROR4(v81, 2);
		v89 = v90;
		v92 = ROR4(v81, 27);
		v91 = v85 + v92;
		v93 = ROR4(v595 ^ v593 ^ v601 ^ v606, 31);

		v94 = v93;
		v96 = ROR4(v91, 2);
		v95 = v96;
		v98 = ROR4(v91, 27);
		v97 = v607 + 1518500249 + v73 + (v86 ^ v77) + v98;
		v99 = ROR4(v596 ^ v594 ^ v602 ^ v607, 31);
		v100 = v99;
		v102 = ROR4(v97, 2);
		v101 = v102;
		v103 = (v95 ^ v89) & v97 ^ v89;
		v105 = ROR4(v97, 27);
		v104 = v88 + 1518500249 + v77 + ((v89 ^ v83) & v91 ^ v83) + v105;
		v107 = ROR4(v104, 2);
		v106 = v107;
		v108 = (v101 ^ v95) & v104;
		v110 = ROR4(v104, 27);
		v109 = v94 + 1518500249 + v83 + v103 + v110;
		v111 = ROR4(v597 ^ v595 ^ v603 ^ v88, 31);
		v591 = v111;
		v112 = v100 + 1518500249 + v89 + (v108 ^ v95);
		v113 = v111 + 1518500249 + v95;
		v114 = ROR4(v598 ^ v596 ^ v604 ^ v94, 31);
		v115 = v114;
		v117 = ROR4(v109, 27);
		v116 = v112 + v117;
		v119 = ROR4(v109, 2);
		v118 = v119;
		v120 = ROR4(v599 ^ v597 ^ v605 ^ v100, 31);
		v121 = v120;
		v123 = ROR4(v116, 27);
		v122 = v113 + ((v106 ^ v101) & v109 ^ v101) + v123;
		v125 = ROR4(v116, 2);
		v124 = v125;
		v126 = v125 ^ v118;
		v128 = ROR4(v122, 27);
		v127 = v115 + 1859775393 + v101 + (v118 ^ v106 ^ v116) + v128;
		v129 = v121 + 1859775393 + v106;
		v131 = ROR4(v122, 2);
		v130 = v131;
		v133 = ROR4(v600 ^ v598 ^ v606 ^ v591, 31);
		v132 = v133;
		v134 = ROR4(v601 ^ v599 ^ v607 ^ v115, 31);
		v135 = v132;
		v136 = v134;
		v137 = v134;
		v139 = ROR4(v127, 27);
		v138 = v129 + (v126 ^ v122) + v139;
		v141 = ROR4(v127, 2);
		v140 = v141;
		v142 = ROR4(v602 ^ v600 ^ v88 ^ v121, 31);
		v143 = v142;
		v145 = ROR4(v138, 27);
		v144 = v132 + 1859775393 + v118 + (v130 ^ v124 ^ v127) + v145;
		v147 = ROR4(v138, 2);
		v146 = v147;
		v148 = v137 + 1859775393 + v124 + (v140 ^ v130 ^ v138);
		v149 = v147 ^ v140;
		v151 = ROR4(v144, 27);
		v150 = v148 + v151;
		v152 = v143 + 1859775393 + v130;
		v154 = ROR4(v144, 2);
		v153 = v154;
		v155 = ROR4(v603 ^ v601 ^ v94 ^ v135, 31);
		v156 = v155;
		v157 = v155 + 1859775393;
		v158 = v152 + (v149 ^ v144);
		v160 = ROR4(v150, 2);
		v159 = v160;
		v162 = ROR4(v150, 27);
		v161 = v158 + v162;
		v163 = ROR4(v604 ^ v602 ^ v100 ^ v136, 31);
		v164 = v163;
		v165 = v163 + 1859775393;
		v166 = ROR4(v605 ^ v603 ^ v591 ^ v143, 31);
		v167 = v166;
		v168 = v166;
		v170 = ROR4(v161, 27);
		v169 = v157 + v140 + (v153 ^ v146 ^ v150) + v170;
		v171 = v165 + v146;
		v173 = ROR4(v161, 2);
		v172 = v173;
		v174 = v171 + (v159 ^ v153 ^ v161);
		v175 = v168 + 1859775393 + v153;
		v176 = v173 ^ v159;
		v177 = ROR4(v606 ^ v604 ^ v115 ^ v156, 31);
		v178 = v177;
		v179 = ROR4(v607 ^ v605 ^ v121 ^ v164, 31);
		v180 = v179;
		v182 = ROR4(v169, 2);
		v181 = v182;
		v184 = ROR4(v169, 27);
		v183 = v174 + v184;
		v186 = ROR4(v183, 27);
		v185 = v175 + (v176 ^ v169) + v186;
		v188 = ROR4(v183, 2);
		v187 = v188;
		v189 = ROR4(v88 ^ v606 ^ v135 ^ v167, 31);
		v190 = v189;
		v192 = ROR4(v185, 27);
		v191 = v178 + 1859775393 + v159 + (v181 ^ v172 ^ v183) + v192;
		v194 = ROR4(v185, 2);
		v193 = v194;
		v195 = v180 + 1859775393 + v172 + (v187 ^ v181 ^ v185);
		v196 = v100 ^ v88 ^ v143;
		v198 = ROR4(v94 ^ v607 ^ v136 ^ v178, 31);
		v197 = v198;
		v200 = ROR4(v191, 27);
		v199 = v195 + v200;
		v201 = v197;
		v202 = v190 + 1859775393 + v181;
		v204 = ROR4(v191, 2);
		v203 = v204;
		v205 = ROR4(v196 ^ v180, 31);
		v206 = v591 ^ v94;
		v207 = v205;
		v208 = v205;
		v210 = ROR4(v199, 27);
		v209 = v202 + (v193 ^ v187 ^ v191) + v210;
		v212 = ROR4(v199, 2);
		v211 = v212;
		v213 = v100;
		v214 = v197 + 1859775393 + v187 + (v203 ^ v193 ^ v199);
		v215 = v115 ^ v213 ^ v164;
		v216 = v208 + 1859775393 + v193 + (v212 ^ v203 ^ v209);
		v218 = ROR4(v206 ^ v156 ^ v190, 31);
		v217 = v218;
		v220 = ROR4(v209, 2);
		v219 = v220;
		v222 = ROR4(v209, 27);
		v221 = v214 + v222;
		v224 = ROR4(v214 + v222, 27);
		v223 = v216 + v224;
		v225 = v217 + 1859775393 + v203;
		v227 = ROR4(v221, 2);
		v226 = v227;
		v229 = ROR4(v215 ^ v201, 31);
		v228 = v229;
		v230 = ROR4(v121 ^ v591 ^ v167 ^ v207, 31);
		v231 = v228;
		v591 = v230;
		v233 = ROR4(v223, 27);
		v232 = v225 + (v219 ^ v211 ^ v221) + v233;
		v235 = ROR4(v223, 2);
		v234 = v235;
		v236 = v235 ^ v226 ^ v232;
		v237 = ROR4(v135 ^ v115 ^ v178 ^ v217, 31);
		v238 = v237;
		v240 = ROR4(v232, 2);
		v239 = v240;
		v242 = ROR4(v232, 27);
		v241 = v228 + 1859775393 + v211 + (v226 ^ v219 ^ v223) + v242;
		v243 = ROR4(v136 ^ v121 ^ v180 ^ v228, 31);
		v244 = v243;
		v246 = ROR4(v143 ^ v135 ^ v190 ^ v591, 31);
		v245 = v246;
		v248 = ROR4(v241, 2);
		v247 = v248;
		v250 = ROR4(v241, 27);
		v249 = v591 + 1859775393 + v219 + v236 + v250;
		v251 = v245;
		v253 = ROR4(v249, 27);
		v252 = v238 + 1859775393 + v226 + (v239 ^ v234 ^ v241) + v253;
		v255 = ROR4(v249, 2);
		v254 = v255;
		v256 = v255 ^ v247;
		v257 = ROR4(v156 ^ v136 ^ v201 ^ v238, 31);
		v258 = v257;
		v260 = ROR4(v252, 2);
		v259 = v260;
		v262 = ROR4(v252, 27);
		v261 = v244 + 1859775393 + v234 + (v247 ^ v239 ^ v249) + v262;
		v263 = ROR4(v164 ^ v143 ^ v207 ^ v244, 31);
		v264 = v263;
		v266 = ROR4(v261, 27);
		v265 = v245 + 1859775393 + v239 + (v256 ^ v252) + v266;
		v267 = v258 + 1859775393 + v247;
		v269 = ROR4(v261, 2);
		v268 = v269;
		v270 = v267 + (v259 ^ v254 ^ v261);
		v271 = v265 | v269;
		v273 = ROR4(v265, 27);
		v272 = v270 + v273;
		v275 = ROR4(v265, 2);
		v274 = v275;
		v276 = ROR4(v167 ^ v156 ^ v217 ^ v245, 31);
		v277 = v276;
		v278 = v276 - 1894007588 + v259 + ((v272 | v274) & v268 | v272 & v274);
		v279 = ROR4(v178 ^ v164 ^ v231 ^ v258, 31);
		v280 = v279;
		v282 = ROR4(v272, 27);
		v281 = v264 - 1894007588 + v254 + (v271 & v259 | v265 & v268) + v282;
		v284 = ROR4(v272, 2);
		v283 = v284;
		v285 = ROR4(v180 ^ v167 ^ v591 ^ v264, 31);
		v286 = v285;
		v288 = ROR4(v281, 27);
		v287 = v278 + v288;
		v290 = ROR4(v281, 2);
		v289 = v290;
		v291 = (v281 | v283) & v274 | v281 & v283;
		v292 = (v287 | v290) & v283 | v287 & v290;
		v293 = ROR4(v190 ^ v178 ^ v238 ^ v277, 31);
		v294 = v293;
		v296 = ROR4(v287, 27);
		v295 = v280 - 1894007588 + v268 + v291 + v296;
		v298 = ROR4(v287, 2);
		v297 = v298;
		v299 = v286 - 1894007588 + v274 + v292;
		v300 = v295 | v298;
		v302 = ROR4(v295, 27);
		v301 = v299 + v302;
		v304 = ROR4(v295, 2);
		v303 = v304;
		v305 = ROR4(v201 ^ v180 ^ v244 ^ v280, 31);
		v306 = v305;
		v307 = v294 - 1894007588 + v283 + (v300 & v289 | v295 & v297);
		v308 = v305;
		v310 = ROR4(v301, 27);
		v309 = v307 + v310;
		v312 = ROR4(v301, 2);
		v311 = v312;
		v313 = ROR4(v207 ^ v190 ^ v251 ^ v286, 31);
		v314 = v313;
		v315 = v313;
		v317 = ROR4(v309, 2);
		v316 = v317;
		v319 = ROR4(v309, 27);
		v318 = v308 - 1894007588 + v289 + ((v301 | v303) & v297 | v301 & v303) + v319;
		v320 = ROR4(v217 ^ v201 ^ v258 ^ v294, 31);
		v321 = v320;
		v322 = v320 - 1894007588 + v303 + ((v318 | v316) & v311 | v318 & v316);
		v324 = ROR4(v318, 27);
		v323 = v315 - 1894007588 + v297 + ((v309 | v311) & v303 | v309 & v311) + v324;
		v326 = ROR4(v318, 2);
		v325 = v326;
		v328 = ROR4(v231 ^ v207 ^ v264 ^ v306, 31);
		v327 = v328;
		v330 = ROR4(v323, 27);
		v329 = v322 + v330;
		v332 = ROR4(v323, 2);
		v331 = v332;
		v333 = ROR4(v591 ^ v217 ^ v277 ^ v314, 31);
		v334 = v327 - 1894007588 + v311;
		v335 = v333;
		v336 = v333 - 1894007588 + v316 + ((v329 | v331) & v325 | v329 & v331);
		v338 = ROR4(v329, 27);
		v337 = v334 + ((v323 | v325) & v316 | v323 & v325) + v338;
		v340 = ROR4(v329, 2);
		v339 = v340;
		v342 = ROR4(v238 ^ v231 ^ v280 ^ v321, 31);
		v341 = v342;
		v344 = ROR4(v244 ^ v591 ^ v286 ^ v327, 31);
		v343 = v344;
		v346 = ROR4(v337, 27);
		v345 = v336 + v346;
		v348 = ROR4(v337, 2);
		v347 = v348;
		v591 = v343;
		v349 = v341;
		v350 = v341 - 1894007588 + v325;
		v351 = (v337 | v339) & v331 | v337 & v339;
		v352 = v343 - 1894007588 + v331;
		v353 = (v345 | v348) & v339 | v345 & v348;
		v355 = ROR4(v251 ^ v238 ^ v294 ^ v335, 31);
		v354 = v355;
		v357 = ROR4(v345, 27);
		v356 = v350 + v351 + v357;
		v358 = v354;
		v360 = ROR4(v345, 2);
		v359 = v360;
		v361 = v354 - 1894007588;
		v362 = v356 | v360;
		v364 = ROR4(v356, 27);
		v363 = v352 + v353 + v364;
		v366 = ROR4(v356, 2);
		v365 = v366;
		v367 = v362 & v347 | v356 & v359;
		v368 = ROR4(v258 ^ v244 ^ v306 ^ v349, 31);
		v369 = v368;
		v370 = v368 - 1894007588 + v347;
		v371 = ROR4(v264 ^ v251 ^ v314 ^ v591, 31);
		v372 = v371;
		v373 = (v363 | v365) & v359 | v363 & v365;
		v375 = ROR4(v363, 27);
		v374 = v361 + v339 + v367 + v375;
		v377 = ROR4(v363, 2);
		v376 = v377;
		v378 = v374 | v377;
		v380 = ROR4(v374, 27);
		v379 = v370 + v373 + v380;
		v382 = ROR4(v374, 2);
		v381 = v382;
		v383 = ROR4(v277 ^ v258 ^ v321 ^ v358, 31);
		v384 = v383;
		v385 = v372 - 1894007588 + v359 + (v378 & v365 | v374 & v376);
		v386 = v383 - 1894007588 + v365;
		v387 = (v379 | v381) & v376 | v379 & v381;
		v389 = ROR4(v379, 27);
		v388 = v385 + v389;
		v391 = ROR4(v280 ^ v264 ^ v327 ^ v369, 31);
		v390 = v391;
		v393 = ROR4(v379, 2);
		v392 = v393;
		v394 = v390;
		v395 = v388 | v393;
		v396 = v386 + v387;
		v398 = ROR4(v388, 2);
		v397 = v398;
		v400 = ROR4(v388, 27);
		v399 = v396 + v400;
		v401 = ROR4(v286 ^ v277 ^ v335 ^ v372, 31);
		v402 = v401;
		v403 = v390 - 1894007588 + v376 + (v395 & v381 | v388 & v392);
		v404 = v401 - 1894007588 + v381;
		v405 = ROR4(v294 ^ v280 ^ v349 ^ v384, 31);
		v406 = v405;
		v407 = v404 + ((v399 | v397) & v392 | v399 & v397);
		v408 = v405;
		v410 = ROR4(v399, 27);
		v409 = v403 + v410;
		v412 = ROR4(v399, 2);
		v411 = v412;
		v413 = ROR4(v306 ^ v286 ^ v591 ^ v390, 31);
		v414 = v413;
		v416 = ROR4(v409, 27);
		v415 = v407 + v416;
		v418 = ROR4(v409, 2);
		v417 = v418;
		v419 = ROR4(v314 ^ v294 ^ v358 ^ v402, 31);
		v420 = v419;
		v421 = v408 - 1894007588 + v392 + ((v409 | v411) & v397 | v409 & v411);
		v422 = v419;
		v424 = ROR4(v415, 2);
		v423 = v424;
		v426 = ROR4(v415, 27);
		v425 = v421 + v426;
		v427 = v422 - 899497514;
		v428 = v414 - 1894007588 + v397;
		v429 = v314;
		v430 = ROR4(v321 ^ v306 ^ v369 ^ v406, 31);
		v431 = v428 + ((v415 | v417) & v411 | v415 & v417);
		v432 = v430;
		v433 = v427 + v411 + (v423 ^ v417 ^ v425);
		v434 = v430;
		v436 = ROR4(v425, 2);
		v435 = v436;
		v438 = ROR4(v425, 27);
		v437 = v431 + v438;
		v439 = ROR4(v327 ^ v429 ^ v372 ^ v414, 31);
		v440 = v439;
		v441 = v434 - 899497514 + v417 + (v435 ^ v423 ^ v437);
		v442 = v439;
		v444 = ROR4(v437, 27);
		v443 = v433 + v444;
		v446 = ROR4(v437, 2);
		v445 = v446;
		v447 = ROR4(v335 ^ v321 ^ v384 ^ v420, 31);
		v448 = v447;
		v449 = v447;
		v451 = ROR4(v443, 2);
		v450 = v451;
		v453 = ROR4(v443, 27);
		v452 = v441 + v453;
		v454 = v591 ^ v335;
		v456 = ROR4(v349 ^ v327 ^ v394 ^ v432, 31);
		v455 = v456;
		v458 = ROR4(v452, 27);
		v457 = v442 - 899497514 + v423 + (v445 ^ v435 ^ v443) + v458;
		v459 = v455;
		v461 = ROR4(v452, 2);
		v460 = v461;
		v462 = v449 - 899497514 + v435 + (v450 ^ v445 ^ v452);
		v463 = v358 ^ v349;
		v464 = ROR4(v454 ^ v402 ^ v440, 31);
		v465 = v464;
		v466 = v463 ^ v406 ^ v448;
		v467 = v455 - 899497514 + v445 + (v460 ^ v450 ^ v457);
		v469 = ROR4(v457, 27);
		v468 = v462 + v469;
		v471 = ROR4(v457, 2);
		v470 = v471;
		v472 = ROR4(v466, 31);
		v473 = v369 ^ v591;
		v591 = v472;
		v475 = ROR4(v468, 2);
		v474 = v475;
		v477 = ROR4(v468, 27);
		v476 = v467 + v477;
		v478 = v465 - 899497514 + v450 + (v470 ^ v460 ^ v468);
		v479 = ROR4(v473 ^ v414 ^ v459, 31);
		v480 = v372 ^ v358 ^ v420;
		v481 = v479;
		v482 = v479;
		v483 = v591 - 899497514 + v460 + (v474 ^ v470 ^ v476);
		v485 = ROR4(v476, 2);
		v484 = v485;
		v487 = ROR4(v476, 27);
		v486 = v478 + v487;
		v488 = v384 ^ v369 ^ v432;
		v489 = ROR4(v480 ^ v465, 31);
		v490 = v489;
		v491 = v372;
		v493 = ROR4(v486, 2);
		v492 = v493;
		v495 = ROR4(v488 ^ v591, 31);
		v494 = v495;
		v497 = ROR4(v486, 27);
		v496 = v483 + v497;
		v498 = v494;
		v500 = ROR4(v496, 27);
		v499 = v482 - 899497514 + v470 + (v484 ^ v474 ^ v486) + v500;
		v502 = ROR4(v496, 2);
		v501 = v502;
		v504 = ROR4(v394 ^ v491 ^ v440 ^ v481, 31);
		v503 = v504;
		v505 = v402 ^ v384;
		v507 = ROR4(v499, 27);
		v506 = v490 - 899497514 + v474 + (v492 ^ v484 ^ v496) + v507;
		v508 = v503;
		v509 = v494 - 899497514 + v484;
		v511 = ROR4(v499, 2);
		v510 = v511;
		v512 = v406 ^ v394;
		v513 = ROR4(v505 ^ v448 ^ v490, 31);
		v514 = v513;
		v516 = ROR4(v506, 27);
		v515 = v509 + (v501 ^ v492 ^ v499) + v516;
		v517 = v503 - 899497514 + v492;
		v519 = ROR4(v506, 2);
		v518 = v519;
		v520 = v517 + (v510 ^ v501 ^ v506);
		v521 = v519 ^ v510;
		v523 = ROR4(v515, 2);
		v522 = v523;
		v525 = ROR4(v515, 27);
		v524 = v520 + v525;
		v527 = ROR4(v512 ^ v459 ^ v494, 31);
		v526 = v527;
		v528 = v527 - 899497514 + v510 + (v522 ^ v518 ^ v524);
		v530 = ROR4(v524, 2);
		v529 = v530;
		v532 = ROR4(v524, 27);
		v531 = v514 - 899497514 + v501 + (v521 ^ v515) + v532;
		v534 = ROR4(v414 ^ v402 ^ v465 ^ v508, 31);
		v533 = v534;
		v535 = v534 - 899497514;
		v537 = ROR4(v420 ^ v406 ^ v591 ^ v514, 31);
		v536 = v537;
		v539 = ROR4(v531, 27);
		v538 = v528 + v539;
		v540 = v535 + v518;
		v542 = ROR4(v531, 2);
		v541 = v542;
		v543 = ROR4(v432 ^ v414 ^ v481 ^ v526, 31);
		v544 = v420;
		v545 = v543;
		v547 = ROR4(v538, 2);
		v546 = v547;
		v549 = ROR4(v538, 27);
		v548 = v540 + (v529 ^ v522 ^ v531) + v549;
		v550 = v536 - 899497514 + v522 + (v541 ^ v529 ^ v538);
		v552 = ROR4(v440 ^ v544 ^ v490 ^ v533, 31);
		v551 = v552;
		v553 = v545 - 899497514 + v529 + (v546 ^ v541 ^ v548);
		v555 = ROR4(v548, 2);
		v554 = v555;
		v557 = ROR4(v548, 27);
		v556 = v550 + v557;
		v558 = v448 ^ v432 ^ v498 ^ v536;
		v560 = ROR4(v550 + v557, 27);
		v559 = v553 + v560;
		v562 = ROR4(v556, 2);
		v561 = v562;
		v563 = ROR4(v558, 31);
		v564 = v563 - 899497514;
		v566 = ROR4(v559, 27);
		v565 = v551 - 899497514 + v541 + (v554 ^ v546 ^ v556) + v566;
		v568 = ROR4(v559, 2);
		v567 = v568;
		v569 = ROR4(v459 ^ v440 ^ v508 ^ v545, 31);
		v570 = v564 + v546 + (v561 ^ v554 ^ v559);
		v571 = v569 - 899497514 + v554;
		v573 = ROR4(v565, 27);
		v572 = v570 + v573;
		v574 = v571 + (v567 ^ v561 ^ v565);
		v576 = ROR4(v565, 2);
		v575 = v576;
		v578 = ROR4(v572, 27);
		v577 = v574 + v578;
		v579 = v575 ^ v567 ^ v572;
		v581 = ROR4(v465 ^ v448 ^ v514 ^ v551, 31);
		v580 = v581;
		v583 = ROR4(v572, 2);
		v582 = v583;
		v585 = ROR4(v577, 27);
		v584 = v585; // 0xba0b5a21
		v592 = null;
		v587 = bytes2Int(result, 0) - 899497514 + v580 + v561 + v579 + v584;
		v588 = bytes2Int(result, 4) + v577;
		v589 = bytes2Int(result, 8) + v582;
		v590 = bytes2Int(result, 12) + v575;
		int2bytes(result, bytes2Int(result, 16) + v567, 16);
		int2bytes(result, v587, 0);
		int2bytes(result, v588, 4);
		int2bytes(result, v589, 8);
		int2bytes(result, v590, 12);
		return result;
	}

	public  byte[] getSingnature2(byte[] inputs) {
		byte[] result = new byte[20];
		byte[] temp = new byte[132];
		byte[] resultTemp = new byte[92];
		int v4 = bytes2Int(inputs, 20);
		int v13 = reverseOrder(v4);
		int v5 = reverseOrder(bytes2Int(inputs, 24));
		int v6 = (v4 >> 3) & 0x3F;
		int v7;
		if (v6 > 55)
			v7 = 120 - v6;
		else
			v7 = 56 - v6;
		temp[0] = (byte) -128;
		getSingnature1(temp, v7, inputs);
		int2bytes(temp, v5, 0);
		int2bytes(temp, v13, 4);
		getSingnature1(temp, 8, inputs);
		resultTemp = inputs;
		int2bytes(result, reverseOrder(bytes2Int(resultTemp, 0)), 0);
		int2bytes(result, reverseOrder(bytes2Int(resultTemp, 4)), 4);
		int2bytes(result, reverseOrder(bytes2Int(resultTemp, 8)), 8);
		int2bytes(result, reverseOrder(bytes2Int(resultTemp, 12)), 12);
		int2bytes(result, reverseOrder(bytes2Int(resultTemp, 16)), 16);
		return result;
	}

	public  String byte2hexString(byte[] paramArrayOfByte) {
		char[] arrayOfChar = new char[2 * paramArrayOfByte.length];
		for (int i = 0; i < paramArrayOfByte.length; i++) {
			int j = (char) (0xF & (0xF0 & paramArrayOfByte[i]) >> 4);
			int k = i * 2;
			if (j <= 9) {
				j = j + 48;
			} else {
				j = j + 97 - 10;// 97 小写 65大写
			}
			arrayOfChar[k] = (char) j;
			j = (char) (0xF & paramArrayOfByte[i]);
			k = 1 + i * 2;
			if (j <= 9) {
				j = j + 48;
			} else {
				j = j + 97 - 10;
			}
			arrayOfChar[k] = (char) j;
		}
		return new String(arrayOfChar);
	}

	public  String getHmacSHA1(String data, String key) {
		try {
			SecretKeySpec secretkey = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA1");
			Mac mac = Mac.getInstance("HmacSHA1");
			mac.init(((Key) secretkey));
			return Base64.encode(mac.doFinal(data.toString().getBytes("UTF-8"))).replace("\r\n", "");
		} catch (Exception e2) {
		}
		return "";
	}

	public  String gettransId() {
		String uid = UUID.randomUUID().toString();
		return uid.replaceAll("-", "");
	}

	public  String getTimeStamp() {
		String result = "";
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		result = dateFormat.format(now);
		return result;
	}

	public  String getRequestTime() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	public  String getitemMethod(String itemMethod) {
		int n = Integer.valueOf(itemMethod);
		switch (n) {
		case 1:
		case 3:
		case 11:
			return "1";
		case 2:
			return "2";
		case 5:
		case 7:
		case 15:
			return "5";
		case 6:
			return "6";
		}
		return itemMethod;

	}

	public  String AESEncrypt(byte[] data, byte[] keyByte) {
		String result = null;
		byte[] IV = new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		byte[] tmp = new byte[80];
		System.arraycopy(data, 0, tmp, 0, data.length);

		SecretKeySpec aesKey = new SecretKeySpec(keyByte, "AES");
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("AES/CBC/NoPadding");
			cipher.init(1, aesKey, new IvParameterSpec(IV));
			result = Base64.encode(cipher.doFinal(tmp));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.replaceAll("\\+", "-").replaceAll("\\/", "_");
	}

	public  String md52String32(byte[] bytes) {
		StringBuffer localStringBuffer;
		try {
			MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
			localMessageDigest.update(bytes);
			byte[] arrayOfByte = localMessageDigest.digest();
			localStringBuffer = new StringBuffer("");
			for (int i2 = 0; i2 < arrayOfByte.length; i2++) {
				int i1 = arrayOfByte[i2];
				if (i1 < 0)
					i1 += 256;
				if (i1 < 16)
					localStringBuffer.append("0");
				localStringBuffer.append(Integer.toHexString(i1));
			}
			return localStringBuffer.toString().toUpperCase();
		} catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
			localNoSuchAlgorithmException.printStackTrace();
		}
		return "";
	}

	public  byte[] hexString2Bytes(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
		}
		return d;
	}

	public  byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}

	public  String getContextByTag(String context, String tag) {
		String result = "-1";
		int start = context.indexOf("<" + tag + ">") + ("<" + tag + ">").length();
		int end = context.indexOf("</" + tag + ">");
		if (start != -1 && end != -1)
			result = context.substring(start, end);
		//System.out.println(tag + ":\t" + result);
		return result;
	}

	public  int[] getIntArrayFromString(String value) {
		int intArray[] = new int[value.length() / 4];
		int begin = 0;
		int end = 4;
		for (int i = 0; i < value.length(); i = i + 4) {
			Integer temp = Integer.valueOf(stringToFourByteHexString(value.substring(begin, end)), 16);
			intArray[i / 4] = temp.intValue();
			end += 4;
			begin += 4;
		}
		return intArray;
	}

	public  String stringToFourByteHexString(String str) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			int ch = (int) str.charAt(i);
			String s4 = Integer.toHexString(ch);
			stringBuilder.append(s4);
		}
		return stringBuilder.toString();
	}

	public  int ROR4(int signed, int shift) {
		// long unsigned = Integer.toUnsignedLong(signed);
		long unsigned = (long) signed & 0x0FFFFFFFFL;
		long right = unsigned >> shift;
		long left = unsigned << (32 - shift);
		long temp = left | right;
		return (int) temp;
	}

	public  int bytes2Int(byte[] src, int offset) {
		return (int) ((src[offset] & 0xFF) | ((src[offset + 1] & 0xFF) << 8) | ((src[offset + 2] & 0xFF) << 16) | ((src[offset + 3] & 0xFF) << 24));
	}

	public  byte[] int2bytes(byte[] src, int value, int offset) {
		byte[] a = new byte[4];
		a[3] = (byte) ((value >> 24) & 0xff);
		a[2] = (byte) ((value >> 16) & 0xff);
		a[1] = (byte) ((value >> 8) & 0xff);
		a[0] = (byte) ((value) & 0xff);
		for (int i = 0; i < 4; i++) {
			src[offset + i] = a[i];
		}
		return src;
	}

	public  byte[] int2bytes(int value) {
		byte[] a = new byte[4];
		a[3] = (byte) ((value >> 24) & 0xff);
		a[2] = (byte) ((value >> 16) & 0xff);
		a[1] = (byte) ((value >> 8) & 0xff);
		a[0] = (byte) ((value) & 0xff);
		return a;
	}

	public  int reverseOrder(int data) {
		int v1 = ROR4(data, 24);
		int v3 = ROR4(data, 8);
		return v1 & 0xFF00FF | v3 & 0xFF00FF00;
	}

	public  byte[] byteMerger(byte[] byte_1, byte[] byte_2) {
		byte[] byte_3 = new byte[byte_1.length + byte_2.length];
		System.arraycopy(byte_1, 0, byte_3, 0, byte_1.length);
		System.arraycopy(byte_2, 0, byte_3, byte_1.length, byte_2.length);
		return byte_3;
	}

}
