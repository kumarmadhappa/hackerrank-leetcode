package transactionsByLocationAndIP;


import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.StringTokenizer;

import com.google.gson.Gson;

class Transaction
{
    String id;
    String userId;
    String userName;
    String timestamp;
    String txnType;
    String amount;
    Location location;
    String ip;

    public Transaction()
    {

    }

    public Transaction(String id, String userId, String userName, String timestamp, String txnType, String amount, Location location, String ip)
    {
        super();
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.timestamp = timestamp;
        this.txnType = txnType;
        this.amount = amount;
        this.location = location;
        this.ip = ip;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(String timestamp)
    {
        this.timestamp = timestamp;
    }

    public String getTxnType()
    {
        return txnType;
    }

    public void setTxnType(String txnType)
    {
        this.txnType = txnType;
    }

    public String getAmount()
    {
        return amount;
    }

    public void setAmount(String amount)
    {
        this.amount = amount;
    }

    public Location getLocation()
    {
        return location;
    }

    public void setLocation(Location location)
    {
        this.location = location;
    }

    public String getIp()
    {
        return ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }

    @Override
    public String toString()
    {
        return "Transaction [id=" + id + ", userId=" + userId + ", userName=" + userName + ", timestamp=" + timestamp
                + ", txnType=" + txnType + ", amount=" + amount + ", location=" + location + ", ip=" + ip + "]";
    }

}

class Location
{

    String id;
    String address;
    String city;
    String zipCode;

    public Location()
    {

    }

    public Location(String id, String address, String city, String zipCode)
    {
        super();
        this.id = id;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }

    @Override
    public String toString()
    {
        return "Location [id=" + id + ", address=" + address + ", city=" + city + ", zipCode=" + zipCode + "]";
    }

}

class ResponseData{
    String page;
    String per_page;
    String total;
    String total_pages;
    List<Transaction> data;
    
    public ResponseData()
    {
        
    }
    
    public ResponseData(String page, String per_page, String total, String total_pages, List<Transaction> data)
    {
        super();
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
    }
    public String getPage()
    {
        return page;
    }
    public void setPage(String page)
    {
        this.page = page;
    }
    public String getPer_page()
    {
        return per_page;
    }
    public void setPer_page(String per_page)
    {
        this.per_page = per_page;
    }
    public String getTotal()
    {
        return total;
    }
    public void setTotal(String total)
    {
        this.total = total;
    }
    public String getTotal_pages()
    {
        return total_pages;
    }
    public void setTotal_pages(String total_pages)
    {
        this.total_pages = total_pages;
    }
    public List<Transaction> getData()
    {
        return data;
    }
    public void setData(List<Transaction> data)
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return "ResponseData [page=" + page + ", per_page=" + per_page + ", total=" + total + ", total_pages="
                + total_pages + ", data=" + data + "]";
    }
    
}

class Result
{

    /*
     * Complete the 'getExpenditure' function below.
     *
     * The function is expected to return an INTEGER. The function accepts following
     * parameters: 1. INTEGER userId 2. INTEGER locationId 3. INTEGER netStart 4.
     * INTEGER netEnd
     *
     * https://jsonmock.hackerrank.com/api/transactions/search?userId=
     */

    static float sum = 0;
    static int pageNum = -1;
    static int totalPages = -1;
    static List<Transaction> tnxs= new ArrayList<Transaction>();

    public static int getExpenditure(int userId, int locationId, int netStart, int netEnd)
    {
        try
        {
            URL urlForGetRequest1 = new URL("https://jsonmock.hackerrank.com/api/transactions/search?userId=" + userId);
            callApi(urlForGetRequest1);
            if (pageNum != totalPages)
            {
                for (int i = 2; i <= totalPages; i++)
                {
                    URL urlForGetRequest2 = new URL(
                            "https://jsonmock.hackerrank.com/api/transactions/search?userId=" + userId + "&page=" + i);
                    callApi(urlForGetRequest2);
                }
            }
            
            calculatePartialExpenditure(locationId, netStart, netEnd);
        }
        catch (Exception ex)
        {

        }

        return Math.round(sum);

    }

    public static void callApi(URL url)
    {

        try
        {
            String readLine = null;
            HttpURLConnection conection = (HttpURLConnection) url.openConnection();
            conection.setDoInput(true);
            conection.setRequestMethod("GET");
            int responseCode = conection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK)
            {
                BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
                StringBuffer response = new StringBuffer();
                while ((readLine = in.readLine()) != null)
                {
                    response.append(readLine);
                }
                in.close();
                
                Gson gson1  = new Gson();
                
                ResponseData resp = gson1.fromJson(response.toString(), ResponseData.class);
                tnxs.addAll(resp.getData());

                if (pageNum == -1)
                    pageNum = Integer.parseInt(resp.getPage());
                if (totalPages == -1)
                    totalPages = Integer.parseInt(resp.getTotal_pages());
            }
            else
            {
                
            }

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

    public static void calculatePartialExpenditure(int locationId, int netStart, int netEnd)
    {
        
        tnxs.stream().filter(t -> t.getLocation().getId().equals(String.valueOf(locationId)))
        .filter(t -> {
            String ip = t.getIp();
            int first = -1;
            StringTokenizer st = new StringTokenizer(ip, ".");
            while (st.hasMoreTokens())
            {
                first = Integer.parseInt(st.nextToken());
                break;
            }
            if (first != -1 && first >= netStart && first <= netEnd)
            {
                return true;
            }
            return false;
            })
        .forEach(t -> {
            String amount = t.getAmount();
            amount = amount.replace(",", "");
            sum += Double.parseDouble(amount.substring(1));
            });
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
	
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int userId = Integer.parseInt(bufferedReader.readLine().trim());

        int locationId = Integer.parseInt(bufferedReader.readLine().trim());

        int netStart = Integer.parseInt(bufferedReader.readLine().trim());

        int netEnd = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.getExpenditure(userId, locationId, netStart, netEnd);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
		*/
		//input 2 (1,2,25,50)
		
		int userId = 3;
		int locationId = 8;
		int netStart = 5;
		int netEnd = 50;
		
		int result = Result.getExpenditure(userId, locationId, netStart, netEnd);
		System.out.println(String.valueOf(result));
    }
}
