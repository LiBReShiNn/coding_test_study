//package annotations;
//
//public class ApiAnnotation {
//
//    @PostMapping()
//    @ApiOperation(value = "게시판 공고 등록", notes = "게시판 공고를 등록한다")
//    @ApiResponses({
//            @ApiResponse(code = 204, message = "성공"),
//            @ApiResponse(code = 401, message = "인증 실패"),
//            @ApiResponse(code = 404, message = "사용자 없음"),
//            @ApiResponse(code = 500, message = "서버 오류")
//    })
//    public ResponseEntity<BoardRegisterRes> registerAdoptBoard(@RequestParam(value="data") BoardRegisterPostReq boardRegisterPostReq,
//                                                               @RequestParam(value="thumbnailUrl") MultipartFile thumbnailUrl,
//                                                               @RequestParam(value="fileList") List<MultipartFile> fileList
//    ) throws IOException {
//
//    }
//
//    @PostMapping(consumes = {"multipart/form-data"})
//    @ApiOperation(value = "게시판 공고 등록", notes = "게시판 공고를 등록한다")
//    @ApiResponses({
//            @ApiResponse(code = 204, message = "성공"),
//            @ApiResponse(code = 401, message = "인증 실패"),
//            @ApiResponse(code = 404, message = "사용자 없음"),
//            @ApiResponse(code = 500, message = "서버 오류")
//    })
//    public ResponseEntity<BoardRegisterRes> registerAdoptBoard(@ModelAttribute BoardRegisterPostReq boardRegisterPostReq) throws IOException {
//        Board board = boardService.registerBoard(boardRegisterPostReq);
//        System.out.println(board);
//        return ResponseEntity.ok(BoardRegisterRes.of(200, "공고가 정상적으로 등록되었습니다", board.getId()));
//    }
//
//}
