/*    */ package helpers;
/*    */ 
/*    */ public class Arithmetic
/*    */ {
/*    */   public static int strToInteger(String str)
/*    */   {
/*    */     try
/*    */     {
/* 15 */       if ((str.length() > 0) && (isNumeric(str))) {
               int strIndex=str.indexOf(".");
               if(strIndex>0) { 
               str=str.substring(0, strIndex);
               return Integer.parseInt(str);
               }
/*    */       }
/*    */ 
/*    */     }
/*    */     catch (Exception e)
/*    */     {
                System.out.println(e.getMessage());
/*    */     }
/*    */    return Integer.parseInt(str);
/* 25 */   //  return 0;
/*    */   }
/*    */ 
/*    */   public static long strToLong(String str)
/*    */   {
/*    */     try {
/* 31 */       if ((str.length() > 0) && (isNumeric(str))) {
               int strIndex=str.indexOf(".");
               if(strIndex>0)  
               str=str.substring(0, strIndex);    
/* 32 */         return Long.parseLong(str);
/*    */       }
/*    */ 
/*    */     }
/*    */     catch (Exception e)
/*    */     {
                // log app.Novia.pd.hideProgressDialog();
/*    */     }
/*    */ 
/* 41 */     return 0L;
/*    */   }
/*    */ 
/*    */   public static float strToFloat(String str)
/*    */   {
/*    */     try {
/* 47 */       if ((str.length() > 0) && (isNumeric(str))) {
/* 48 */         return Float.parseFloat(str);
/*    */       }
/*    */ 
/*    */     }
/*    */     catch (Exception e)
/*    */     {
                //log app.Novia.pd.hideProgressDialog();
/*    */     }
/*    */ 
/* 57 */     return 0.0F;
/*    */   }
/*    */ 
/*    */   public static double strToDouble(String str)
/*    */   {
/*    */     try {
/* 63 */       if ((str.length() > 0) && (isNumeric(str))) {
/* 64 */         return Double.parseDouble(str);
/*    */       }
/*    */ 
/*    */     }
/*    */     catch (Exception e)
/*    */     {
                //log app.Novia.pd.hideProgressDialog();
/*    */     }
/*    */ 
/* 73 */     return 0.0D;
/*    */   }
/*    */ 
/*    */   public static boolean isNumeric(String str) {
/* 77 */     if (str.equals("-1"))
/* 78 */       return true;
/* 79 */     return str.matches("\\d*(\\.\\d+)?");
/*    */   }
/*    */ 
/*    */   public static String cleanNumericString(String temp) {
/* 83 */     temp = temp.replaceAll("\t", "");
/*    */ 
/* 85 */     temp = temp.replaceAll("\n", "");
/*    */ 
/* 87 */     temp = temp.replaceAll("\r", "");
/*    */ 
/* 89 */     return temp.replaceAll("[^0-9.]", "");
/*    */   }
/*    */ }

/* Location:           D:\flash\EXAM SYSTEM\examssystem.jar
 * Qualified Name:     app.helpers.Arithmetic
 * JD-Core Version:    0.6.2
 */