@ECHO OFF
solc ..\Contracts\CMS.sol --bin --abi --optimize -o ..\Contracts\build --overwrite
call %web3j% solidity generate --binFile=..\Contracts\build\Connection.bin --abiFile=..\Contracts\build\Connection.abi -p com.springboot.ConsentManagement.ContractModel -o ..\src\main\java\
call %web3j% solidity generate --binFile=..\Contracts\build\ConnectionFile.bin --abiFile=..\Contracts\build\ConnectionFile.abi -p com.springboot.ConsentManagement.ContractModel -o ..\src\main\java\
call %web3j% solidity generate --binFile=..\Contracts\build\ConsentTemplate.bin --abiFile=..\Contracts\build\ConsentTemplate.abi -p com.springboot.ConsentManagement.ContractModel -o ..\src\main\java\
call %web3j% solidity generate --binFile=..\Contracts\build\Consent.bin --abiFile=..\Contracts\build\Consent.abi -p com.springboot.ConsentManagement.ContractModel -o ..\src\main\java\
call %web3j% solidity generate --binFile=..\Contracts\build\ConsentFile.bin --abiFile=..\Contracts\build\ConsentFile.abi -p com.springboot.ConsentManagement.ContractModel -o ..\src\main\java\
call %web3j% solidity generate --binFile=..\Contracts\build\ConsentManagementSystem.bin --abiFile=..\Contracts\build\ConsentManagementSystem.abi -p com.springboot.ConsentManagement.ContractModel -o ..\src\main\java\
