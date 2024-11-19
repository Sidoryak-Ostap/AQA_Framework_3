jmeter -n -t load.jmx -Jduration=270 -JuserNumber=30 -Jhost=localhost -l summary.csv

jmeter -g summary.csv -o report


-Jload_profile="line(1,30,1m) const(30,2m) line(30,1,1m)"

jmeter -n -t load.jmx -Jduration=240 -JuserNumber=30 -Jhost=localhost -Jload_profile="line(1,30,1m) const(30,2m) line(30,1,1m)" -l summary.csv -e -o report
