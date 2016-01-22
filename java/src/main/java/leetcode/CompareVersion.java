package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * CompareVersion
 *
 * @since 2015-11-06
 */
public class CompareVersion {

    public int compareVersion(String version1, String version2) {
        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");
        int shortest = version1Array.length < version2Array.length ? version1Array.length : version2Array.length;

        for (int i = 0; i < shortest; i++) {
            int v1 = Integer.valueOf(version1Array[i]);
            int v2 = Integer.valueOf(version2Array[i]);
            if (v1 > v2) {
                return 1;
            }
            if (v1 < v2) {
                return -1;
            }
        }

        int lastSignificantVersionNumberIndex1 = lastSignificantVersionNumberIndex(version1Array);
        int lastSignificantVersionNumberIndex2 = lastSignificantVersionNumberIndex(version2Array);

        if (lastSignificantVersionNumberIndex1 > lastSignificantVersionNumberIndex2) {
            return 1;
        }
        if (lastSignificantVersionNumberIndex2 > lastSignificantVersionNumberIndex1) {
            return -1;
        }

        return 0;
    }

    public int lastSignificantVersionNumberIndex(String[] versionNumberArray) {
        for (int i = versionNumberArray.length - 1; i >= 0; i--) {
            if (Integer.valueOf(versionNumberArray[i]) != 0) {
                return i;
            }
        }
        return versionNumberArray.length - 1;
    }

    @Test
    public void compareVersionTest() {
        Assert.assertEquals(0, compareVersion("1", "1"));
        Assert.assertEquals(0, compareVersion("1.1", "1.1"));
        Assert.assertEquals(0, compareVersion("1", "1.0"));
        Assert.assertEquals(1, compareVersion("1.1", "1"));
        Assert.assertEquals(1, compareVersion("2", "1"));
        Assert.assertEquals(-1, compareVersion("1", "1.1"));
        Assert.assertEquals(-1, compareVersion("1", "2"));
    }
}
