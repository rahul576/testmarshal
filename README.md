# testmarshal
# By Rahul Shrivastava
This is a Test Management software for automated tests , we can store the test results via provides APIs 


Test Case Details:
    {
        t_id
        t_name
        t_detail
        t_steps
    }
Test Run Details:
    {
        t_id
        run_id
        rel_id
        ec_id
        t_status {PASS ,FAIL,SKIP,NOT_RUN,BLOCKED}
        start_time
        end_time
        img_path
        logs
    }
Release:
{
    rel_id
    rel_name
    rel_version
}

User:
{ 
  name
  email
  id
}
________________________________________________________
API Endpoints
________________________________________________________
POST:
    "test/add"
    "run/add"
    "release/add"
    "user/add"
    "cycle/add"
GET:
    "test/all"   -required pagination here 
    "test/sid"
    "run/run_id"
    "run/all"
    "release/release_id"
    "release/all"
    "cycle/{cycleid)"
    "cycle/all"
    "user/{id}"
    "user/all"
PUT:
    "run/(id)
DELETE:
    "test/{id}"
    "run/(id)"
    "release/{id}"
    "user/{id}" "cycle/{id}"